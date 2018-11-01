import psycopg2
from db_configuration import config


def main(params):
    card_number = params.get("cardNumber")
    conn = None
    json = {}
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute("select * from debitcard where cardnumber = %s", [card_number])
        row = cur.fetchone()

        while row is not None:
            json = {"cardNumber": card_number, "agency": row[1], "account": row[2], "status": row[3]}
            row = cur.fetchone()

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return json


print(main({"cardNumber": 12345}))

def main(params):
    agency = params.get("agency", 123)
    account = params.get("account", 456)
    return {"agency": agency, "account": account, "name": "John Cena", "status": "ACTIVE", "balance": 100}

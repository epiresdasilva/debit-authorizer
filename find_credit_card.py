def main(params):
    cardNumber = params.get("cardNumber", "1234567890")
    return {"cardNumber": cardNumber, "agency": 123, "account": 456, "status": "ACTIVE"}

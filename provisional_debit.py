def main(params):
    agency = params.get("agency", 123)
    account = params.get("account", 456)
    debitValue = params.get("debitValue", 10)
    return {"agency": agency, "account": account, "debitValue": debitValue}

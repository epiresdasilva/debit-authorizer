FROM lambci/lambda

RUN pip install psycopg2
RUN pip install psycopg2-binary
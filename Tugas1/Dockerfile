FROM python:3.10-slim-buster

WORKDIR /lat1

COPY requirements.txt .

RUN pip install --no-cache-dir --upgrade pip && \
    pip install --no-cache-dir -r requirements.txt

COPY lat1/ .

EXPOSE 5000

CMD ["python", "manage.py", "runserver", "0.0.0.0:5000"]

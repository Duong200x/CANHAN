# CANHAN

Mục tiêu: clone repo → chạy 1 lệnh là có stack hoạt động.

## Yêu cầu
- Docker + Docker Compose

## Chạy (Windows)

### CMD
```bat
copy .env.example .env
docker compose up -d --build
“Kiểm tra: mở http://localhost:8080” và “MongoDB port 27017 không mở bằng trình duyệt”.

chạy node+mogo: docker compose -f docker-compose.mongo.yml -f app.node.yml up -d --build
chạy python + Mysql: docker compose -f docker-compose.mysql.yml -f app.python.yml up -d --build
chạy java + mogo + firebase: docker compose -f docker-compose.mongo.yml -f docker-compose.firebase-emulator.yml -f app.java.yml up -d --build

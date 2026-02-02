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
# CANHAN

Mục tiêu: clone repo → chạy lệnh là có stack hoạt động. Repo có nhiều “stack mẫu” (Node/Python/Java + DB + Firebase Emulator). Chọn stack nào thì chạy đúng lệnh stack đó.
---
## Yêu cầu
- Docker Desktop (Windows)
- Docker Compose (đi kèm Docker Desktop)

Kiểm tra đã cài:
### CMD
```bat
docker --version
docker compose version

Stack mặc định (demo) — chạy nhanh
CMD
docker compose up -d --build
docker compose ps

Link check:Web demo: http://localhost:8080
Dừng stack demo:

docker compose down
Tạo .env (tuỳ chọn)

Nếu bạn muốn tự cấu hình biến môi trường (không bắt buộc nếu compose đã có default):

CMD
copy .env.example .env

PowerShell
Copy-Item .env.example .env

Các stack mẫu (khuyến nghị chạy 1 stack tại 1 thời điểm)
1 Node + Mongo
Chạy (CMD)
docker compose -p node-mongo -f docker-compose.mongo.yml -f app.node.yml up -d --build
docker compose -p node-mongo ps


Link check:

Node health: http://localhost:3000/health

Dừng:

docker compose -p node-mongo down

2 Python + MySQL
Chạy (CMD)
docker compose -p py-mysql -f docker-compose.mysql.yml -f app.python.yml up -d --build
docker compose -p py-mysql ps


Link check:

Python health: http://localhost:8000/health

Dừng:

docker compose -p py-mysql down

3 Java + Mongo + Firebase Emulator

Ghi chú port:

Java app: 8082

Firebase Emulator UI: 4000

Mongo của stack này nên dùng host port khác 27017 để tránh trùng (ví dụ 27018)

Chạy (CMD)
set MONGO_PORT=27018
docker compose -p java-mongo-fb -f docker-compose.mongo.yml -f docker-compose.firebase-emulator.yml -f app.java.yml up -d --build
docker compose -p java-mongo-fb ps


Link check:

Java health: http://localhost:8082/health

Firebase Emulator UI: http://localhost:4000

Dừng:

docker compose -p java-mongo-fb down

Chạy (PowerShell)
$env:MONGO_PORT="27018"
docker compose -p java-mongo-fb -f docker-compose.mongo.yml -f docker-compose.firebase-emulator.yml -f app.java.yml up -d --build
docker compose -p java-mongo-fb ps

Lệnh kiểm tra & log
Xem trạng thái
docker compose ps
docker compose -p node-mongo ps
docker compose -p py-mysql ps
docker compose -p java-mongo-fb ps

Xem log (theo stack)
docker compose logs -f
docker compose -p node-mongo logs -f
docker compose -p py-mysql logs -f
docker compose -p java-mongo-fb logs -f

Xem log riêng Firebase Emulator
docker compose -p java-mongo-fb logs -f firebase-emulator

Dừng toàn bộ 3 stack mẫu (nếu bạn đang chạy cả 3)
docker compose -p node-mongo down
docker compose -p py-mysql down
docker compose -p java-mongo-fb down

Lỗi thường gặp: “port is already allocated”

Nếu gặp lỗi bind port (ví dụ 27017/8080/4000), xử lý nhanh:

Dừng stack đang chạy chiếm port:

docker compose down
docker compose -p node-mongo down
docker compose -p py-mysql down
docker compose -p java-mongo-fb down

Chạy lại stack cần dùng.

Cleanup (xoá luôn volume dữ liệu — mất DB):

docker compose down -v
docker compose -p node-mongo down -v
docker compose -p py-mysql down -v
docker compose -p java-mongo-fb down -v
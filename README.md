# AI Cờ Tướng (Vietnamese Chess AI)

Dự án game **Cờ Tướng** viết bằng Java, tích hợp trí tuệ nhân tạo (AI) để đấu với người chơi.

## Giới thiệu

Đây là một ứng dụng game Cờ Tướng (Chinese Chess) có giao diện đồ họa (Swing) và AI có khả năng tự suy nghĩ nước đi. Dự án được xây dựng theo mô hình kiến trúc **MVC (Model – View – Controller)**.

## Tính năng

- 🎮 **Người vs Máy**: Người chơi đấu với AI
- 👥 **Người vs Người**: Hai người chơi trên cùng một máy
- 🧠 **AI thông minh**: Sử dụng thuật toán Alpha-Beta Pruning kết hợp Quiescence Search
- ⚙️ **Chọn độ khó**: Điều chỉnh độ sâu tìm kiếm của AI (level)
- 💾 **Lưu / Tải ván đấu**: Lưu trạng thái ván cờ ra file và tải lại sau
- ↩️ **Hoàn tác (Undo)**: Lùi lại nước đi vừa thực hiện
- 🖥️ **Giao diện Swing**: Cửa sổ không viền, có thể kéo di chuyển bằng chuột

## Kiến trúc dự án

```
src/
├── model/          # Dữ liệu và logic game
│   ├── chess/      # Các loại quân cờ (Tướng, Sĩ, Tượng, Mã, Pháo, Xe, Tốt)
│   ├── map/        # File bàn cờ mặc định và ván đã lưu
│   ├── Match.java          # Trạng thái ván đấu, di chuyển, lưu/tải
│   ├── Constant.java       # Hằng số toàn cục
│   ├── ChessPosition.java  # Vị trí ô trên bàn cờ
│   ├── MoveInfo.java       # Thông tin một nước đi
│   ├── Player.java         # Thông tin người chơi
│   └── ...
├── view/           # Giao diện người dùng (Swing)
│   ├── Main.java           # Điểm khởi động ứng dụng
│   ├── MainFrame.java      # Cửa sổ chính
│   ├── ChessBoardPanel.java# Vẽ bàn cờ và xử lý sự kiện chuột
│   ├── MenuPanel.java      # Menu điều hướng chính
│   └── ...
├── control/        # Điều khiển và AI
│   ├── Computer.java       # AI: Alpha-Beta, Quiescence Search
│   ├── Evaluate.java       # Hàm đánh giá thế cờ (điểm quân, vị trí)
│   ├── Position.java       # Trạng thái một quân cờ
│   └── ComponentMover.java # Hỗ trợ kéo cửa sổ
└── images/         # Tài nguyên hình ảnh (bàn cờ, quân cờ, giao diện)
```

## Các quân cờ

| Quân     | Tên tiếng Việt | Ký hiệu |
|----------|----------------|---------|
| King     | Tướng          | 7       |
| Advisor  | Sĩ             | 2       |
| Bishop   | Tượng          | 3       |
| Knight   | Mã             | 4       |
| Cannon   | Pháo           | 5       |
| Rook     | Xe             | 6       |
| Pawn     | Tốt            | 1       |

## Thuật toán AI

- **Alpha-Beta Pruning**: Tối ưu hóa Minimax, cắt tỉa các nhánh không cần thiết
- **Quiescence Search**: Tiếp tục tìm kiếm với các nước ăn quân để tránh hiệu ứng đường chân trời
- **Hàm đánh giá (Evaluate)**:
  - Giá trị cơ bản của từng loại quân
  - Giá trị vị trí (position tables) cho từng quân trên bàn cờ
  - Phân biệt trạng thái tàn cuộc (endgame) để điều chỉnh giá trị

## Yêu cầu hệ thống

- **Java**: JDK 7 trở lên
- **IDE**: Eclipse (có file `.classpath` và `.project` kèm theo)

## Cách chạy

1. Mở dự án bằng Eclipse (File → Import → Existing Projects into Workspace)
2. Chọn thư mục gốc của dự án
3. Chạy file `src/view/Main.java`

Hoặc compile và chạy bằng dòng lệnh:

```bash
javac -sourcepath src -d bin src/view/Main.java
java -cp bin view.Main
```

## Ảnh minh họa

Thư mục `others/` chứa ảnh chụp giao diện và sơ đồ lớp của dự án:

- `others/1.png` → `others/8.png`: Ảnh chụp màn hình các tính năng
- `others/ClassDiagram.dia`: Sơ đồ lớp (UML) mở bằng Dia
- `others/ClassDiagramMVC.dia`: Sơ đồ MVC

## Tác giả

Dự án được phát triển như một bài tập / đồ án về Trí tuệ Nhân tạo và Lập trình Hướng đối tượng bằng Java.

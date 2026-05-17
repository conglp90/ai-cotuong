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

## Bố cục giao diện (UI Layout)

Cửa sổ chính (`MainFrame`) không có viền, kích thước **800 × 670 px**, chia làm hai vùng đặt cạnh nhau:

```
┌──────────────────────────────────────────────────────────────────────────────────┐
│                        MainFrame  (800 × 670)                                    │
│ ┌──────────────────────────────────────────┐ ┌──────────────────────────────┐   │
│ │        ChessBoardPanel (600 × 670)        │ │      MenuPanel (200 × 670)   │   │
│ │  (hiển thị bàn cờ hoặc màn hình welcome) │ │  (CardLayout – 5 màn hình)   │   │
│ └──────────────────────────────────────────┘ └──────────────────────────────┘   │
└──────────────────────────────────────────────────────────────────────────────────┘
```

---

### Màn hình 1 – Welcome / Trang chủ

> `MenuHomePanel` hiển thị khi mới khởi động. `ChessBoardPanel` vẽ ảnh `welcome2.jpg`.

```
┌──────────────────────────────────────────┬──────────────────────────┐
│                                          │  ┌────────────────────┐  │
│                                          │  │   [Play New Game]  │  │
│            welcome2.jpg                  │  ├────────────────────┤  │
│           (ảnh chào mừng)                │  │  [Create a Game]   │  │
│                                          │  ├────────────────────┤  │
│                                          │  │   [Load a Game]    │  │
│                                          │  ├────────────────────┤  │
│                                          │  │    [Exit Game]     │  │
│                                          │  └────────────────────┘  │
└──────────────────────────────────────────┴──────────────────────────┘
          ChessBoardPanel (600×670)               MenuHomePanel
```

---

### Màn hình 2 – Thiết lập ván mới

> `MenuNewPanel` – người dùng chọn chế độ chơi, ai đi trước và độ khó.

```
┌──────────────────────────────────────────┬──────────────────────────┐
│                                          │  [Back]          [OK]    │
│                                          │  ────────────────────    │
│            welcome2.jpg                  │  Select player mode:     │
│                                          │  (•) Human vs Computer   │
│                                          │  ( ) Human vs Human      │
│                                          │  ────────────────────    │
│                                          │  Who will play first?    │
│                                          │  (•) Computer            │
│                                          │  ( ) Human               │
│                                          │  ────────────────────    │
│                                          │  Select level:           │
│                                          │  (•) Captain America     │
│                                          │  ( ) Iron Man            │
│                                          │  ( ) Thor                │
│                                          │  ( ) Hulk                │
│                                          │  ┌──────────────────┐   │
│                                          │  │  [avatar level]  │   │
│                                          │  └──────────────────┘   │
└──────────────────────────────────────────┴──────────────────────────┘
```

---

### Màn hình 3 – Tạo ván tùy chỉnh

> `MenuCreatePanel` – chức năng đang được phát triển.

```
┌──────────────────────────────────────────┬──────────────────────────┐
│                                          │  Create Game             │
│            welcome2.jpg                  │  [Back]                  │
│                                          │                          │
└──────────────────────────────────────────┴──────────────────────────┘
```

---

### Màn hình 4 – Đang chơi (In-game)

> `MenuPlayPanel` dùng tọa độ tuyệt đối. `ChessBoardPanel` vẽ bàn cờ và quân.

```
┌──────────────────────────────────────────┬──────────────────────────┐
│  ┌─────────────────────────────────────┐ │ ┌──────────────────────┐ │
│  │ Xe Mã Tượng Sĩ Tướng Sĩ Tượng Mã Xe│ │ │  [Avatar AI / đối   │ │
│  │                                     │ │ │   thủ  160×220 px]  │ │ ← lbCom
│  │       · · ·  Pháo · · Pháo          │ │ │              🔮[💭] │ │ ← lbThink
│  │ Tốt Tốt Tốt Tốt Tốt Tốt Tốt Tốt T │ │ │  [⚠️warn]           │ │ ← lbComWarn
│  │ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─  │ │ ├──────────────────────┤ │
│  │ t t t t t t t t t (tốt đỏ)         │ │ │ [🏠]  [🔄]  [💡]   │ │ ← Home/Reset/Hint
│  │       · · ·  pháo · · pháo          │ │ ├──────────────────────┤ │
│  │ xe mã tượng sĩ tướng sĩ tượng mã xe│ │ │ [↩]  [⏸]  [↪]     │ │ ← Undo/Pause/Redo
│  └─────────────────────────────────────┘ │ ├──────────────────────┤ │
│               (quân đỏ ở trên,           │ │ Level ──●──────── 6  │ │ ← slLevel
│                quân đen ở dưới)          │ ├──────────────────────┤ │
│                                          │ │ [Avatar người chơi  │ │
│                                          │ │   160×220 px]       │ │ ← lbHuman
│                                          │ │         [⚠️warn]    │ │ ← lbHumWarn
│                                          │ └──────────────────────┘ │
└──────────────────────────────────────────┴──────────────────────────┘
          ChessBoardPanel (600×670)               MenuPlayPanel (200×670)
```

**Chi tiết vị trí các nút trong `MenuPlayPanel` (tọa độ px):**

```
y=0   ┌──────────────────────────────────────────────┐
      │  lbCom  (avatar AI)   x=20, y=10, 160×220    │
      │                                              │
      │  lbThink (đang suy nghĩ)  x=130, y=10, 50×50 │
y=182 │  lbComWarn ⚠️  x=20, y=182, 48×48            │
y=250 │  [🏠 Home]  [🔄 Reset]  [💡 Hint]           │
      │   x=14        x=76        x=138   (48×48 mỗi)│
y=313 │  [↩ Undo]  [⏸ Pause]  [↪ Redo]             │
      │   x=14        x=76        x=138   (48×48 mỗi)│
y=380 │  Level [────●────────] (slider 2-6)          │
      │         x=70, y=380, 121×50                  │
y=440 │  lbHuman (avatar người)  x=20, y=440, 160×220│
      │                                              │
y=612 │  lbHumWarn ⚠️  x=20, y=612, 48×48           │
y=670 └──────────────────────────────────────────────┘
```

---

### Màn hình 5 – Tạm dừng (Pause)

> Khi nhấn nút ⏸, `ChessBoardPanel` vẽ ảnh `waiting.jpg` thay cho bàn cờ.

```
┌──────────────────────────────────────────┬──────────────────────────┐
│                                          │      (giữ nguyên         │
│              waiting.jpg                 │       MenuPlayPanel)     │
│          (màn hình tạm dừng)             │                          │
└──────────────────────────────────────────┴──────────────────────────┘
```

---

### Luồng điều hướng giữa các màn hình

```
                    ┌─────────────────┐
           ┌───────►│  Welcome/Home   │◄────────────────────┐
           │        │ (MenuHomePanel) │                     │
           │        └────────┬────────┘                     │
           │                 │                              │
           │      ┌──────────┼──────────┐                   │
           │      ▼          ▼          ▼                   │
           │  [New Game] [Create]   [Load Game]             │
           │      │       (dev)         │                   │
           │      ▼                     │                   │
           │ ┌──────────┐              ▼                   │
           │ │ New Game │        ┌──────────────┐           │
           │ │  Setup   │        │  Tải ván lưu │           │
           │ │(NewPanel)│        │(lastmap file)│           │
           │ └────┬─────┘        └──────┬───────┘           │
           │      │   [OK]              │                   │
           │      └──────────┬──────────┘                   │
           │                 ▼                              │
           │         ┌──────────────┐                       │
           │         │   In-game    │──[🏠 Home]────────────┘
           │         │ (PlayPanel)  │
           │         └──────┬───────┘
           │                │ [⏸]
           │         ┌──────▼───────┐
           └─────────│    Pause     │
                     └──────────────┘
```

---

## Ảnh minh họa

Thư mục `others/` chứa ảnh chụp giao diện và sơ đồ lớp của dự án:

- `others/1.png` → `others/8.png`: Ảnh chụp màn hình các tính năng
- `others/ClassDiagram.dia`: Sơ đồ lớp (UML) mở bằng Dia
- `others/ClassDiagramMVC.dia`: Sơ đồ MVC

## Tác giả

Dự án được phát triển như một bài tập / đồ án về Trí tuệ Nhân tạo và Lập trình Hướng đối tượng bằng Java.

# 📦 Data Structure — Java 数据结构与算法学习项目

> Java 数据结构与算法学习笔记，基于 B 站视频教程，使用 Java 21 + Maven 构建。

## 🧭 目录结构

```text
src/
├── main/java/io/github/gamelmw/
│   ├── database/                 # JDBC + MySQL 示例
│   │   └── JdbcDemo.java
│   ├── leetcode/
│   │   ├── ListNode.java         # 链表节点定义
│   │   └── _206/                 # LeetCode 206 — 反转链表（3 种方法）
│   │       ├── Method1.java
│   │       ├── Method2.java
│   │       └── Method3.java
│   ├── recursive/                # 递归
│   │   ├── Factorial.java        # 阶乘
│   │   └── Fibonacci.java        # 斐波那契数列
│   ├── video/array/
│   │   ├── dynamic_arrays/       # 动态数组
│   │   │   └── DynamicArray.java
│   │   └── gai_lun/              # 数组概论
│   ├── video/binary_search/      # 二分查找（含增强版）
│   ├── video/linkedlist/
│   │   ├── singlylinkedlist/                   # 单向链表（哨兵）
│   │   ├── Doublylinkedlistsentinel/           # 双向链表（哨兵）
│   │   └── Doublyringlinkedlistsentinel/       # 双向环形链表（哨兵）
│   ├── video/stack/
│   │   ├── Stack.java             # 栈接口
│   │   ├── arraystack/            # 数组实现栈
│   │   └── linkedliststack/       # 链表实现栈
│   └── video/queue/
│       ├── Queue.java             # 队列接口
│       ├── arrayqueue/            # 数组实现队列（3 种方案）
│       ├── linkedlistqueue/       # 链表实现队列
│       ├── priorityqueue/         # 优先级队列（大/小顶堆）
│       └── deque/
│           ├── Deque.java         # 双端队列接口
│           └── linkedlistdeque/   # 链表实现双端队列
└── test/java/io/github/gamelmw/   # 对应的单元测试
```

## 🚀 快速开始

### 前置要求

- **JDK 21** 或更高版本
- **Apache Maven 3.8+**
- MySQL（可选，仅 `JdbcDemo` 需要）

### 编译与测试

```bash
mvn clean test
```

### 导入 IDE

直接以 **Maven 项目**导入即可。推荐 IntelliJ IDEA。

## 📚 内容概览

### 🔹 线性表

| 模块 | 实现 | 说明 |
|------|------|------|
| `singlylinkedlist` | 单向链表 | 带头哨兵 |
| `Doublylinkedlistsentinel` | 双向链表 | 带头哨兵 |
| `Doublyringlinkedlistsentinel` | 双向环形链表 | 带头哨兵 |

### 🔹 栈 (Stack)

- **`Stack<E>` 接口** — 定义 `push`、`pop`、`peek`、`isEmpty`、`isFull`
- **数组实现** (`ArrayStack`)
- **链表实现** (`LinkedListStack`)

### 🔹 队列 (Queue)

- **`Queue<E>` 接口** — 定义 `offer`、`poll`、`peek`、`isEmpty`、`isFull`
- **数组实现** — 3 种方案（`ArrayQueue1` / `ArrayQueue2` / `ArrayQueue3`）
- **链表实现** (`LinkedListQueue`)
- **优先级队列** — 基于大/小顶堆（`PriorityQueue1` / `PriorityQueue2` / `PriorityQueue3`）
- **双端队列** — 接口 `Deque<E>` + 链表实现 (`LinkedListDeque`)

### 🔹 二分查找 (Binary Search)

| 类 | 说明 |
|------|------|
| `Page1` | 基础实现 |
| `Page1pro` | 进阶版 |
| `Page2` / `Page2pro` | 变体 |
| `Page3` / `Page3pro` | 变体 |
| `Enhanced/Page1` | 增强版 |

### 🔹 动态数组 (Dynamic Array)

- `DynamicArray` — 自动扩容的泛型动态数组

### 🔹 递归 (Recursive)

- **Factorial** — 阶乘递归实现
- **Fibonacci** — 斐波那契数列递归实现

### 🔹 LeetCode 刷题

- **LeetCode 206 — 反转链表** — 3 种实现方法

### 🔹 数据库

- `JdbcDemo` — 使用 **JDBC + MySQL Connector/J** 连接 MySQL 示例

### 🔹 Protobuf

- 项目依赖 `protobuf-java`，提供 Protocol Buffers 序列化支持

## 🧪 单元测试

项目配套完整的 **JUnit 5** 单元测试，覆盖各数据结构核心操作，位于 `src/test/java/` 下。

```bash
mvn test
```

## 🛠 技术栈

| 技术 | 版本 |
|------|------|
| Java | 21 |
| Maven | 3.8+ |
| JUnit | 5.10.2 |
| MySQL Connector/J | 8.4.0 |
| protobuf-java | 3.25.5 |

## 📄 许可证

本项目基于 [Apache License 2.0](./LICENSE) 开源。

## 🙌 致谢

- 数据结构实现参考 B 站相关视频教程
- 单元测试框架使用 JUnit 5

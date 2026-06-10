# Data Structure Learning Project (Java)

[![JDK](https://img.shields.io/badge/JDK-21+-blue.svg)](https://openjdk.org/projects/jdk/21/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-orange.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](LICENSE)

Java 数据结构与算法学习项目，包含线性表、栈、队列、二分查找、递归等经典数据结构的多版本实现与单元测试。

## 目录

- [项目结构](#项目结构)
- [环境要求](#环境要求)
- [快速开始](#快速开始)
- [模块详解](#模块详解)
  - [线性表](#线性表)
  - [栈](#栈)
  - [队列与双端队列](#队列与双端队列)
  - [动态数组](#动态数组)
  - [二分查找](#二分查找)
  - [递归](#递归)
  - [LeetCode 题解](#leetcode-题解)
- [构建与测试](#构建与测试)
- [License](#license)

## 项目结构

```
src/
├── main/java/io/github/gamelmw/
│   ├── leetcode/                          # LeetCode 题解
│   │   ├── ListNode.java                  #   链表节点定义
│   │   └── _206/                          #   反转链表（3 种方法）
│   │       ├── Method1.java               #     创建新节点
│   │       ├── Method2.java               #     改变指针指向
│   │       └── Method3.java               #     递归
│   │
│   ├── recursive/                         # 递归算法
│   │   ├── Factorial.java                 #   阶乘
│   │   └── Fibonacci.java                 #   斐波那契（带缓存优化）
│   │
│   └── video/                             # 数据结构实现
│       ├── array/
│       │   └── dynamic_arrays/
│       │       └── DynamicArray.java      #   动态数组（泛型迭代器）
│       │
│       ├── binary_search/
│       │   ├── Page1.java                 #   基础二分查找
│       │   ├── Page1pro.java              #   进阶版
│       │   ├── Page2.java                 #   左侧重复边界
│       │   ├── Page2pro.java              #   左侧重复边界进阶
│       │   ├── Page3.java                 #   右侧重复边界
│       │   ├── Page3pro.java              #   右侧重复边界进阶
│       │   └── Enhanced/
│       │       └── Page1.java             #   增强版二分查找
│       │
│       ├── linkedlist/
│       │   ├── singlylinkedlist/
│       │   │   └── SinglyLinkedList.java  #   带头哨兵的单链表
│       │   ├── Doublylinkedlistsentinel/
│       │   │   └── DoublyLinkedListSentinel.java  # 带头尾哨兵的双向链表
│       │   └── Doublyringlinkedlistsentinel/
│       │       └── DoublyRingLinkedListSentinel.java  # 带哨兵的双向环形链表
│       │
│       ├── stack/
│       │   ├── Stack.java                 #   栈接口定义
│       │   ├── arraystack/
│       │   │   └── ArrayStack.java        #   数组实现栈
│       │   └── linkedliststack/
│       │       └── LinkedListStack.java   #   链表实现栈
│       │
│       └── queue/
│           ├── Queue.java                 #   队列接口定义
│           ├── arrayqueue/
│           │   ├── ArrayQueue1.java       #   环形数组队列（版本1）
│           │   ├── ArrayQueue2.java       #   环形数组队列（版本2）
│           │   └── ArrayQueue3.java       #   环形数组队列（版本3）
│           ├── linkedlistqueue/
│           │   └── LinkedListQueue.java   #   链表实现队列
│           ├── deque/
│           │   ├── Deque.java             #   双端队列接口
│           │   └── linkedlistdeque/
│           │       └── LinkedListDeque.java # 链表实现双端队列
│           └── priorityqueue/
│               ├── Entry.java             #   优先级队列条目
│               ├── Priority.java          #   优先级接口
│               ├── PriorityQueue1.java    #   无序数组实现
│               ├── PriorityQueue2.java    #   有序数组实现
│               └── PriorityQueue3.java    #   大顶堆实现
│
└── test/java/io/github/gamelmw/           # 单元测试（镜像 main 结构）
    ├── recursive/
    ├── video/array/dynamic_arrays/
    ├── video/binary_search/
    ├── video/binary_search/Enhanced/
    ├── video/linkedlist/singlylinkedlist/
    ├── video/linkedlist/Doublylinkedlistsentinel/
    ├── video/linkedlist/Doublyringlinkedlistsentinel/
    ├── video/stack/arraystack/
    ├── video/stack/linkedliststack/
    └── video/queue/*/
```

## 环境要求

| 依赖       | 版本     |
|------------|----------|
| JDK        | 21+      |
| Maven      | 3.8+     |
| JUnit      | 5.10.2   |

## 快速开始

```bash
# 编译
mvn compile

# 运行所有测试
mvn test

# 打包
mvn package
```

## 模块详解

### 线性表

| 实现 | 类名 | 特点 |
|------|------|------|
| **单链表** | `SinglyLinkedList` | 带头哨兵，支持头插/尾插/按索引插入，遍历与迭代器 |
| **双向链表** | `DoublyLinkedListSentinel` | 带头尾哨兵，双向遍历，`addFirst`/`addLast`/`remove` |
| **双向环形链表** | `DoublyRingLinkedListSentinel` | 带哨兵的双向环形结构，首尾操作 O(1) |
| **动态数组** | `DynamicArray` | 支持自动扩容（1.5 倍），泛型 `Iterable`，流式遍历 |

### 栈

`Stack<E>` 接口定义了 `push`、`pop`、`peek`、`isEmpty`、`isFull` 操作。

| 实现 | 类名 | 特点 |
|------|------|------|
| **数组栈** | `ArrayStack` | 基于数组，有容量限制，支持迭代 |
| **链表栈** | `LinkedListStack` | 基于链表，有容量限制，支持迭代 |

### 队列与双端队列

`Queue<E>` 接口定义了 `offer`、`poll`、`peek` 操作。`Deque<E>` 扩展了双向操作。

| 实现 | 类名 | 特点 |
|------|------|------|
| **环形数组队列** | `ArrayQueue1/2/3` | 3 种实现版本，环形数组，有容量限制 |
| **链表队列** | `LinkedListQueue` | 单向链表实现，支持容量限制与迭代 |
| **链表双端队列** | `LinkedListDeque` | 双向链表实现，支持头尾出入队 |
| **优先级队列（无序）** | `PriorityQueue1` | 基于无序数组，`poll` 时扫描最大优先级 |
| **优先级队列（有序）** | `PriorityQueue2` | 基于有序数组，`offer` 时插入排序 |
| **优先级队列（大顶堆）** | `PriorityQueue3` | 基于大顶堆，`offer` 上浮/`poll` 下沉 |

### 二分查找

| 实现 | 类名 | 说明 |
|------|------|------|
| 基础版 | `Page1` | 标准二分查找 |
| 基础版进阶 | `Page1pro` | 变体实现 |
| 左侧重复边界 | `Page2 / Page2pro` | 查找重复元素最左位置 |
| 右侧重复边界 | `Page3 / Page3pro` | 查找重复元素最右位置 |
| 增强版 | `Enhanced/Page1` | 改进的二分查找实现 |

### 递归

| 实现 | 类名 | 说明 |
|------|------|------|
| 阶乘 | `Factorial` | 递归计算 n! |
| 斐波那契 | `Fibonacci` | 带备忘录缓存的递归实现，时间复杂度 O(n) |

### LeetCode 题解

| 题目 | 方法 | 类名 | 思路 |
|------|------|------|------|
| [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/) | 方法1 | `Method1` | 创建新节点，头插法 |
| | 方法2 | `Method2` | 双指针，原地反转 |
| | 方法3 | `Method3` | 递归反转 |

## 构建与测试

```bash
# 编译所有源代码
mvn compile

# 运行所有单元测试
mvn test

# 运行指定测试类
mvn test -Dtest=SinglyLinkedListTest

# 打包为 JAR
mvn package

# 清理构建产物
mvn clean
```

项目使用 JUnit 5（Jupiter）作为测试框架，每个数据结构都有对应的单元测试类，覆盖主要操作方法。

## License

本项目基于 Apache License 2.0 开源协议，详见 [LICENSE](LICENSE) 文件。

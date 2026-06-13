# Data Structure Learning Project (Java)

[![JDK](https://img.shields.io/badge/JDK-21+-blue.svg)](https://openjdk.org/projects/jdk/21/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-orange.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](LICENSE)

Java 数据结构与算法学习项目，涵盖线性表、栈、队列、双端队列、优先级队列、二分查找、递归等经典数据结构的多版本实现与单元测试。

## 目录

- [环境要求](#环境要求)
- [快速开始](#快速开始)
- [项目结构](#项目结构)
- [模块详解](#模块详解)
  - [线性表](#线性表)
  - [栈](#栈)
  - [队列与双端队列](#队列与双端队列)
  - [优先级队列](#优先级队列)
  - [动态数组](#动态数组)
  - [二分查找](#二分查找)
  - [递归](#递归)
  - [LeetCode 题解](#leetcode-题解)
- [构建与测试](#构建与测试)
- [License](#license)

## 环境要求

| 依赖   | 版本   |
|--------|--------|
| JDK    | 21+    |
| Maven  | 3.8+   |
| JUnit  | 5.14.4 |

## 快速开始

```bash
# 编译
mvn compile

# 运行所有测试
mvn test

# 打包
mvn package
```

## 项目结构

```
src/
+--- main/java/io/github/gamelmw/
|    +--- leetcode/                      # LeetCode 题解
|    |    +--- ListNode.java             #   链表节点定义
|    |    +--- _206/                     #   反转链表（3 种方法）
|    |         +--- Method1.java         #     创建新节点，头插法
|    |         +--- Method2.java         #     双指针，原地反转
|    |         +--- Method3.java         #     递归反转
|    |
|    +--- recursive/                     # 递归算法
|    |    +--- Factorial.java            #   阶乘
|    |    +--- Fibonacci.java            #   斐波那契（备忘录缓存优化）
|    |
|    +--- video/                         # 数据结构实现
|         +--- array/
|         |    +--- gai_lun.txt          #   数组概述笔记
|         |    +--- dynamic_arrays/
|         |         +--- DynamicArray.java # 动态数组（泛型迭代器 + 流式遍历）
|         |
|         +--- binary_search/
|         |    +--- Page1.java           #   基础版二分查找
|         |    +--- Page1pro.java        #   递归版二分查找
|         |    +--- Page2.java           #   左闭右开区间版
|         |    +--- Page2pro.java        #   递归版（左闭右开）
|         |    +--- Page3.java           #   缩小边界版（最快）
|         |    +--- Page3pro.java        #   递归版（缩小边界）
|         |    +--- Enhanced/
|         |         +--- Page1.java      #   增强版（Leftmost / Rightmost）
|         |
|         +--- linkedlist/
|         |    +--- singlylinkedlist/
|         |    |    +--- SinglyLinkedList.java          # 带头哨兵的单链表
|         |    +--- Doublylinkedlistsentinel/
|         |    |    +--- DoublyLinkedListSentinel.java  # 带头尾哨兵的双向链表
|         |    +--- Doublyringlinkedlistsentinel/
|         |         +--- DoublyRingLinkedListSentinel.java # 带哨兵的双向环形链表
|         |
|         +--- stack/
|         |    +--- Stack.java            # 栈接口定义
|         |    +--- arraystack/
|         |    |    +--- ArrayStack.java  # 数组实现栈
|         |    +--- linkedliststack/
|         |         +--- LinkedListStack.java # 链表实现栈
|         |
|         +--- queue/
|              +--- Queue.java            # 队列接口定义
|              +--- arrayqueue/
|              |    +--- ArrayQueue1.java # 环形数组队列（tail 占位判满）
|              |    +--- ArrayQueue2.java # 环形数组队列（size 判满）
|              |    +--- ArrayQueue3.java # 环形数组队列（无取模，整数溢出转正）
|              +--- linkedlistqueue/
|              |    +--- LinkedListQueue.java # 链表队列（环形哨兵）
|              +--- deque/
|              |    +--- Deque.java       # 双端队列接口
|              |    +--- linkedlistdeque/
|              |         +--- LinkedListDeque.java # 双向环形链表实现双端队列
|              +--- priorityqueue/
|                   +--- Entry.java       # 优先级条目
|                   +--- Priority.java    # 优先级接口
|                   +--- PriorityQueue1.java # 无序数组实现（poll O(n)）
|                   +--- PriorityQueue2.java # 有序数组实现（offer O(n)）
|                   +--- PriorityQueue3.java # 大顶堆实现（offer O(log n)）
|
+--- test/java/io/github/gamelmw/         # 单元测试（镜像 main 结构）
     +--- recursive/
     +--- video/array/dynamic_arrays/
     +--- video/binary_search/
     +--- video/binary_search/Enhanced/
     +--- video/linkedlist/singlylinkedlist/
     +--- video/linkedlist/Doublylinkedlistsentinel/
     +--- video/linkedlist/Doublyringlinkedlistsentinel/
     +--- video/stack/arraystack/
     +--- video/stack/linkedliststack/
     +--- video/queue/*/
```

## 模块详解

### 线性表

| 实现         | 类名                           | 特点                                                      |
|--------------|--------------------------------|-----------------------------------------------------------|
| **单链表**   | SinglyLinkedList             | 带头哨兵，支持头插 / 尾插 / 按索引插入，foreach / 迭代器 / 递归遍历 |
| **双向链表** | DoublyLinkedListSentinel     | 带头尾哨兵，双向遍历，addFirst / addLast / insert / remove |
| **双向环形链表** | DoublyRingLinkedListSentinel | 单哨兵双向环形结构，首尾操作 O(1)，支持按值删除            |

### 栈

Stack<E> 接口定义了 push、pop、peek、isEmpty、isFull 操作。

| 实现       | 类名               | 特点                                   |
|------------|---------------------|----------------------------------------|
| **数组栈** | ArrayStack        | 基于数组，有容量限制，迭代器从栈顶开始 |
| **链表栈** | LinkedListStack   | 基于单链表（头插法），有容量限制        |

### 队列与双端队列

Queue<E> 接口定义了 offer、poll、peek、isEmpty、isFull 操作。

| 实现             | 类名                            | 特点                                                |
|------------------|---------------------------------|-----------------------------------------------------|
| **环形数组队列** | ArrayQueue1 / ArrayQueue2 / ArrayQueue3 | 三种实现：tail 占位判满、size 判满、无取模整数溢出转正 |
| **链表队列**     | LinkedListQueue               | 单向链表 + 环形哨兵，支持容量限制与迭代器            |
| **链表双端队列** | LinkedListDeque               | 双向环形链表实现，支持头尾出入队                    |

### 优先级队列

Priority 接口定义 priority() 方法，Entry 为示例条目。

| 实现               | 类名              | offer  | poll/peek | 数据结构   |
|--------------------|-------------------|--------|-----------|------------|
| **无序数组**       | PriorityQueue1  | O(1)   | O(n)      | 普通数组   |
| **有序数组**       | PriorityQueue2  | O(n)   | O(1)      | 插入排序维护有序性 |
| **大顶堆**         | PriorityQueue3  | O(log n)| —        | 二叉堆（上浮） |

### 动态数组

| 类名             | 特点                                                        |
|------------------|-------------------------------------------------------------|
| DynamicArray   | 初始容量 8，1.5 倍扩容，支持 foreach / Consumer / Iterator / Stream 四种遍历方式，支持按索引删除 |

### 二分查找

| 实现                            | 类名                     | 说明                               |
|---------------------------------|--------------------------|------------------------------------|
| 基础版                          | Page1                  | 标准二分查找，统计比较次数         |
| 递归版                          | Page1pro               | 递归实现二分查找                   |
| 左闭右开版                      | Page2                  | 区间 [left, right)                 |
| 左闭右开递归版                  | Page2pro               | 递归实现左闭右开区间               |
| 缩小边界版                      | Page3                  | 缩小至相邻元素再判断，比较次数最少 |
| 缩小边界递归版                  | Page3pro               | 递归实现缩小边界查找               |
| 增强版（Leftmost / Rightmost）  | Enhanced/Page1         | 查找重复元素最左 / 最右位置        |

### 递归

| 实现     | 类名         | 说明                                    |
|----------|--------------|-----------------------------------------|
| 阶乘     | Factorial  | 递归计算 n!                             |
| 斐波那契 | Fibonacci  | 带备忘录缓存的递归实现，时间复杂度 O(n) |

### LeetCode 题解

| 题目 | 方法 | 类名 | 思路 |
|------|------|------|------|
| [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/) | 方法1 | Method1 | 创建新节点，头插法 |
| | 方法2 | Method2 | 双指针，原地反转 |
| | 方法3 | Method3 | 递归反转 |

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

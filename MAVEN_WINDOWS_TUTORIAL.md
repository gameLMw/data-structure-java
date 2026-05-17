# Windows 下 Maven 手把手教程

本文面向没有用过 Maven 的同学，默认开发环境是 Windows，不使用 WSL。

## 1. Maven 是什么

Maven 是 Java 项目的构建工具。它主要解决三个问题：

1. 管理项目依赖，例如 JUnit 测试框架。
2. 统一项目目录结构。
3. 用命令编译、测试、打包项目。

以后只要项目配置好了，就可以用一条命令运行所有测试：

```powershell
mvn test
```

## 2. 安装前准备

安装 Maven 前，电脑上必须先安装 JDK。

统一安装：

- Eclipse Temurin JDK 21
- Maven 3.9.x

安装方式统一使用 zip 压缩包下载后手动解压，不使用 `.msi` 或 `.exe` 安装器。

不要只下载 JRE。Maven 编译 Java 代码需要 JDK。

## 3. 检查是否已经安装 JDK

打开 Windows 终端、PowerShell 或 CMD，输入：

```powershell
java -version
```

再输入：

```powershell
javac -version
```

如果能看到版本号，说明 JDK 基本可用。

示例：

```text
java version "21.0.x"
javac 21.0.x
```

如果 `java` 能用但 `javac` 不能用，通常说明没有正确安装 JDK，或者环境变量没有配置好。

## 4. 安装 JDK

如果电脑没有 JDK，统一安装 Eclipse Temurin JDK。

统一版本：

- Eclipse Temurin JDK 21

### 4.1 下载 JDK zip

进入 Eclipse Temurin 下载页面：

```text
https://adoptium.net/temurin/releases/?version=21
```

页面中选择：

- Operating System：Windows
- Architecture：x64
- Package Type：JDK
- Version：21
- 文件类型：`.zip`

不要下载 `.msi` 或 `.exe` 安装器。

下载后得到类似文件：

```text
OpenJDK21U-jdk_x64_windows_hotspot_21.x.x.zip
```

### 4.2 解压 JDK

下载后统一解压到 JDK 工具目录下，并保留 JDK 自带的版本目录：

```text
X:\tools\java\jdk\jdk-21.x.x
```

其中 `X:` 表示你实际使用的盘符，例如 `D:` 或 `E:`。

正确示例：

```text
X:\tools\java\jdk\jdk-21.x.x\bin
```

其中应该能看到：

```text
X:\tools\java\jdk\jdk-21.x.x\bin\java.exe
X:\tools\java\jdk\jdk-21.x.x\bin\javac.exe
```

这样做的好处是以后可以同时保留多个 JDK 版本，例如：

```text
X:\tools\java\jdk\jdk-21.0.1
X:\tools\java\jdk\jdk-21.0.2
```

以后切换 JDK 版本时，只需要修改 `JAVA_HOME`。

## 5. 配置 JDK 环境变量

### 5.1 打开环境变量设置

步骤：

1. 右键“此电脑”。
2. 点击“属性”。
3. 点击“高级系统设置”。
4. 点击“环境变量”。

后续都在上半部分“用户变量”中配置，不在下半部分“系统变量”中配置。这样只影响当前 Windows 用户，通常也不需要管理员权限。

### 5.2 新建 JAVA_HOME

在“用户变量”中点击“新建”：

```text
变量名：JAVA_HOME
变量值：JDK 安装目录
```

示例：

```text
JAVA_HOME
X:\tools\java\jdk\jdk-21.x.x
```

注意：变量值要写到 JDK 根目录，不要写到 `bin`。

错误示例：

```text
X:\tools\java\jdk\jdk-21.x.x\bin
```

### 5.3 修改 Path

在“用户变量”中找到 `Path`，点击“编辑”，新增：

```text
%JAVA_HOME%\bin
```

保存后，重新打开 PowerShell 或 CMD。

### 5.4 验证 JDK

重新输入：

```powershell
java -version
javac -version
```

两条命令都能显示版本号，才算配置完成。

## 6. 安装 Maven

### 6.1 下载 Maven

进入 Maven 官网下载页面：

```text
https://maven.apache.org/download.cgi
```

下载 Binary zip archive。

不要下载源码包，也不需要安装器。

下载后得到类似文件：

```text
apache-maven-3.9.x-bin.zip
```

### 6.2 解压 Maven

下载后统一解压到 Maven 工具目录下，并保留 Maven 自带的版本目录：

```text
X:\tools\java\maven\apache-maven-3.9.x
```

其中 `X:` 表示你实际使用的盘符，例如 `D:` 或 `E:`。

正确示例：

```text
X:\tools\java\maven\apache-maven-3.9.x\bin
```

这样做的好处是以后可以同时保留多个 Maven 版本，例如：

```text
X:\tools\java\maven\apache-maven-3.9.6
X:\tools\java\maven\apache-maven-3.9.9
```

以后切换 Maven 版本时，只需要修改 `MAVEN_HOME`。

## 7. 配置 Maven 环境变量

### 7.1 新建 MAVEN_HOME

打开环境变量设置，在上半部分“用户变量”中新建：

```text
变量名：MAVEN_HOME
变量值：Maven 解压目录
```

示例：

```text
MAVEN_HOME
X:\tools\java\maven\apache-maven-3.9.x
```

注意：变量值不要写到 `bin`。

错误示例：

```text
X:\tools\java\maven\apache-maven-3.9.x\bin
```

### 7.2 修改 Path

在用户变量 `Path` 中新增：

```text
%MAVEN_HOME%\bin
```

保存后，重新打开 PowerShell 或 CMD。

### 7.3 验证 Maven

输入：

```powershell
mvn -version
```

如果能看到 Maven 版本和 Java 版本，说明安装成功。

示例：

```text
Apache Maven 3.9.x
Java version: 21.0.x
```

## 8. Maven 项目的标准目录

Maven 默认使用下面的目录结构：

```text
项目根目录
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── 正式代码
    └── test
        └── java
            └── 测试代码
```

含义：

- `pom.xml`：Maven 项目配置文件。
- `src/main/java`：放正式代码。
- `src/test/java`：放测试代码。

## 9. pom.xml 是什么

`pom.xml` 是 Maven 项目的配置文件。

它通常会写：

- 项目名称
- Java 版本
- 使用了哪些依赖
- 测试框架配置

一个适合当前项目的基础 `pom.xml` 可以这样写：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>data-structure</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
            </plugin>
        </plugins>
    </build>
</project>
```

## 10. 常用 Maven 命令

在项目根目录下运行，也就是 `pom.xml` 所在目录。

### 10.1 编译正式代码

```powershell
mvn compile
```

### 10.2 编译并运行测试

```powershell
mvn test
```

这是学习项目最常用的命令。

### 10.3 清理编译结果

```powershell
mvn clean
```

Maven 会删除 `target` 目录。

### 10.4 清理后重新测试

```powershell
mvn clean test
```

### 10.5 打包

```powershell
mvn package
```

打包结果会出现在 `target` 目录中。

## 11. 第一次运行 Maven 为什么会很慢

第一次运行 `mvn test` 时，Maven 会从网络下载插件和依赖，例如 JUnit。

这些文件会缓存到本机目录：

```text
C:\Users\你的用户名\.m2\repository
```

第一次慢是正常的。下载完成后，后续运行会快很多。

## 12. 在 IntelliJ IDEA 中使用 Maven

推荐初学者使用 IntelliJ IDEA Community Edition。

### 12.1 打开 Maven 项目

如果项目中已经有 `pom.xml`：

1. 打开 IntelliJ IDEA。
2. 选择 `Open`。
3. 选择项目根目录。
4. IDEA 会识别 `pom.xml`。
5. 等待右下角 Maven 导入完成。

### 12.2 手动刷新 Maven

如果依赖没有加载成功：

1. 打开右侧 Maven 面板。
2. 点击刷新按钮。
3. 等待依赖下载完成。

### 12.3 运行测试

方式一：在测试类左侧点击绿色运行按钮。

方式二：打开终端，运行：

```powershell
mvn test
```

## 13. 如何把当前项目改成 Maven 项目

当前项目还不是标准 Maven 项目。建议分三步改。

### 第一步：添加 pom.xml

在项目根目录新增 `pom.xml`，内容可以先使用上面的基础配置。

### 第二步：调整目录

当前代码在：

```text
src
```

Maven 推荐改成：

```text
src/main/java
src/test/java
```

建议规则：

- 普通实现类放到 `src/main/java`
- `*Test.java` 测试类放到 `src/test/java`

例如：

```text
src/video/array/dynamic_arrays/DynamicArray.java
```

可以移动到：

```text
src/main/java/video/array/dynamic_arrays/DynamicArray.java
```

测试类：

```text
src/video/array/dynamic_arrays/DynamicArrayTest.java
```

可以移动到：

```text
src/test/java/video/array/dynamic_arrays/DynamicArrayTest.java
```

注意：移动文件时，`package` 声明要和目录结构对应。

例如文件内容开头是：

```java
package video.array.dynamic_arrays;
```

那么文件路径就应该是：

```text
src/main/java/video/array/dynamic_arrays/DynamicArray.java
```

### 第三步：运行测试

在项目根目录打开 PowerShell，运行：

```powershell
mvn test
```

如果所有测试通过，就说明 Maven 配置成功。

## 14. 常见问题

### 14.1 mvn 不是内部或外部命令

原因：Maven 没有加入 `Path`。

检查：

- 是否配置了 `MAVEN_HOME`
- `Path` 中是否有 `%MAVEN_HOME%\bin`
- 是否重新打开了 PowerShell 或 CMD

### 14.2 javac 不是内部或外部命令

原因：JDK 没装好，或者 `JAVA_HOME` / `Path` 没配好。

检查：

- 是否安装的是 JDK，而不是 JRE
- `JAVA_HOME` 是否指向 JDK 根目录
- `Path` 中是否有 `%JAVA_HOME%\bin`

### 14.3 Could not resolve dependencies

原因：Maven 下载依赖失败。

可能情况：

- 网络不稳定。
- 公司或校园网限制访问。
- 代理配置不正确。

可以先换网络重试：

```powershell
mvn clean test
```

### 14.4 测试类找不到 JUnit

常见原因：

- `pom.xml` 没有添加 JUnit 依赖。
- IDEA 没有刷新 Maven。
- 测试类没有放在 `src/test/java`。

### 14.5 package 和目录不一致

Java 的包名要和目录对应。

例如：

```java
package video.stack.arraystack;
```

对应路径应该是：

```text
src/main/java/video/stack/arraystack/ArrayStack.java
```

如果目录不一致，IDE 可能会报红。

## 15. 给本项目同学的建议

刚开始使用 Maven 时，不需要理解所有配置。

先记住三件事：

1. `pom.xml` 管理项目配置和依赖。
2. 正式代码放 `src/main/java`。
3. 测试代码放 `src/test/java`。

日常最常用命令只有一个：

```powershell
mvn test
```

等这个命令能稳定跑通，再慢慢学习依赖、插件、打包和多模块项目。

# JUnit spec runner

## 概要

テストコードを[Jasmine](http://jasmine.github.io/)のように書けるようにするJUnitのRunnerです。

## サンプル

```java
public class CalcSpecs extends Specs{{
    
    it("1 足す 2 は 3", () -> {
        expect(() -> 1 + 2).toEqual(3);
    });

    describe("割り算", () -> {
        it("6 割る 3 は 2", () -> {
            expect(() -> 6 / 3).toEqual(2);
        });

        it("1 割る 0 は例外", () -> {
            expect(() -> 1 / 0).toThrow(ArithmeticException.class);
        });
    });

}}
```

## 使い方

pom.xmlに次のdependency要素を追加してください。

```xml
<dependency>
  <groupId>backpaper0</groupId>
  <artifactId>junit-spec-runner</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

repository要素も追加します。

```xml
<repository>
  <id>junit-spec-runner-m2repo</id>
  <url>https://github.com/backpaper0/junit-spec-runner/raw/m2repo/</url>
</repository>
```

## ライセンス

* [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)


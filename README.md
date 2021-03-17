# cash-register-app
Cash Register

# Introduction
  This Cash register application is developed for client demo purposes only.

# Required Tools
- git
- maven 3
- java 8 (LTS) or 11 (LTS)

# Clone The Project Repository
```
$ git clone https://github.com/rnl2004/cash-register-app.git
```

# Build The Application
```
$ cd cash-register-app
$ mvn clean install

NOTE: It will create a jar file within target folder
```

# To Run The Unit Test
```
$ mvn test

Output:
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.rocketmiles.cashregister.CashRegisterAppApplicationTest
13:31:49.188 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - put  1 2 3 4 5
13:31:49.190 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - >>> Showing bills in cash register <<<
13:31:49.192 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - Current State: $68 1 2 3 4 5
13:31:49.198 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - put  1 2 3 0 5
13:31:49.198 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - >>> Showing bills in cash register <<<
13:31:49.198 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - Current State: $128 2 4 6 4 10
13:31:49.199 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - take  1 4 3 0 10
13:31:49.199 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - >>> Showing bills in cash register <<<
13:31:49.200 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - Current State: $43 1 0 3 4 0
13:31:49.200 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - change 11
13:31:49.202 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - $20 => count = 0
13:31:49.203 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - $10 => count = 1
13:31:49.203 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - $5 => count = 0
13:31:49.203 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - $2 => count = 0
13:31:49.203 [main] INFO com.rocketmiles.cashregister.service.CashRegisterBillsServiceImpl - $1 => count = 1
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.156 s - in com.rocketmiles.cashregister.CashRegisterAppApplicationTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.724 s
[INFO] Finished at: 2021-03-17T13:31:49+08:00
[INFO] ------------------------------------------------------------------------
```

# Run The Cash Register Application in Console
```
$ java -jar target/cashregister-0.0.1-SNAPSHOT.jar
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.3)

2021-03-17 13:28:30.078  INFO 23338 --- [           main] c.r.c.CashRegisterAppApplication         : Starting CashRegisterAppApplication v0.0.1-SNAPSHOT using Java 11.0.10 on devcore with PID 23338 (/home/rnl2004/java-app-poc/test_app/cash-register-app/target/cashregister-0.0.1-SNAPSHOT.jar started by rnl2004 in /home/rnl2004/java-app-poc/test_app/cash-register-app)
2021-03-17 13:28:30.082  INFO 23338 --- [           main] c.r.c.CashRegisterAppApplication         : No active profile set, falling back to default profiles: default
2021-03-17 13:28:30.401  INFO 23338 --- [           main] c.r.c.CashRegisterAppApplication         : Started CashRegisterAppApplication in 0.874 seconds (JVM running for 1.35)
2021-03-17 13:28:30.406  INFO 23338 --- [           main] c.r.c.CashRegisterAppApplication         : >>> Ready...
2021-03-17 13:28:30.407  INFO 23338 --- [           main] c.r.c.CashRegisterAppApplication         : >>> Please enter a cash register command(s) below <<<
2021-03-17 13:28:30.407  INFO 23338 --- [           main] c.r.c.CashRegisterAppApplication         : ! show = show bills, put = add bills, take = take out bills, change = get change bills and quit (q)
2021-03-17 13:28:30.407  INFO 23338 --- [           main] c.r.c.CashRegisterAppApplication         : >>> 


```


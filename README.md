# Email
This repository contains an **Email.java program**, a **TcpServer.java**, and a **TcpClient.java** program.
The main program, Email.java, was built using TcpServer.java as a basis, and TcpClient.java for context.

The program establishes a connection with Chapman's SMTP server, to allow a simple Email message exchange.

The **Email.java** program:
+ First queries the user for the necessary data:
    - Sender address
    - Receiver address
    - Sender name
    - Receiver name
    - Message subject
    - Message body
+ Then the client connects to the smtp.chapman.edu server and transmits the message through a series of negotiations.
+ All commands sent and all subsequent responses are displayed chronologically

It is important to note that input can be provided to the program as prompted, as well as through a pre-written file, by use of the command line input redirection feature, available on most operating systems.  

A tester file is provided: **email.input**. Each data is shown on a new line in the order shown above.

To run the program:
+ Optional: Edit the email.input program to accommodate your email data
+ Compile using `javac Email.java`
+ Run using `java Email < email.input`
+ Or `java Email` if you wish to provide manual input

## Identifying Information

* Name: Lisa Pham
* Student ID: 2338933
* Email: thupham@chapman.edu
* Course: CPSC 353-01 Data Comm./Computer Networks
* Assignment: PA01 Email

## Source Files

* Email.java
* TcpClient.java
* TcpServer.java
* email.input
* README.md

## References

* *Computer Networks: A Top-Down Approach, 7th Edition by James Kurose and Keith Ross*

## Known Errors

* There are no known errors.

## Build Insructions

* `javac Email.java`

## Execution Instructions

* `java Email < email.input` explained further above.

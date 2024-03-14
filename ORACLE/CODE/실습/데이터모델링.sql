CREATE TABLE "users" (
	"user_id"	VARCHAR2(50)		NOT NULL,
	"user_pw"	VARCHAR2(50)		NULL,
	"name"	VARCHAR2(10)		NULL,
	"age"	NUMBER		NULL,
	"job"	VARCHAR2(20)		NULL,
	"grade"	VARCHAR2(20)		NULL,
	"point"	NUMBER		NULL
);

CREATE TABLE "orders" (
	"order_no"	NUMBER		NOT NULL,
	"user_id"	VARCHAR2(50)		NOT NULL,
	"product_no"	NUMBER		NOT NULL,
	"amount"	NUMBER		NULL,
	"address"	VARCHAR2(1000)		NULL,
	"order_date"	DATE		NULL
);

CREATE TABLE "product" (
	"product_no"	NUMBER		NOT NULL,
	"name"	VARCHAR2(50)		NULL,
	"amount"	VARCHAR2(1000)		NULL,
	"order_date"	DATE		NULL
);

ALTER TABLE "users" ADD CONSTRAINT "PK_USERS" PRIMARY KEY (
	"user_id"
);

ALTER TABLE "orders" ADD CONSTRAINT "PK_ORDERS" PRIMARY KEY (
	"order_no"
);

ALTER TABLE "product" ADD CONSTRAINT "PK_PRODUCT" PRIMARY KEY (
	"product_no"
);


# HibernateInverseExample
Using XML Mapping

Inverse
-------
The <b> inverse </b> keyword is always declare in <b>one-to-many</b> and <b>many-to-one</b> bi-directional relationship.
where <b>one-to-many</b> has inverse keyword while <b>many-to-one</b> doesn't have inverse keyword.
inverse tells which side is responsible to take care of relationship.
inverse changes relationship owner, in short, <b>inverse=true</b> means this is relationship owner.

Bi-directional relationship between Stock and stock_daily_records entities:

<b>One-To-Many</b><br>
Stock  1 -------------------------------------------------------------- * StockDailyRecords

<b>Many-To-One</b><br>
StockDailyRecords *---------------------------------------------------------------1 Stock


if <b>inverse=true</b> in the set variable, it means stock_daily_record is the relationship owner, so Stock will not update 
the relationship.

     #<set name="stockDailyRecords" table="stock_daily_record" inverse="true"  fetch="select">
			<key column="stock_id" not-null="true"/>
			<one-to-many class="com.hibernate.inverseexample.model.StockDailyRecord" />
		</set>

if <b>inverse=false</b> (default) in the set variable, it means Stock is the relationship owner, so Stock will update 
the relationship.

     #<set name="stockDailyRecords" table="stock_daily_record" inverse="false"  fetch="select">
			<key column="stock_id" not-null="true"/>
			<one-to-many class="com.hibernate.inverseexample.model.StockDailyRecord" />
		</set>

To understand this concept we will have to look over console logger where which query executed.

RDBMS (MySQL) Script:
---------------------

CREATE TABLE `stock` (
  `stock_id` bigint(20) NOT NULL AUTO_INCREMENT,
   `stock_code` varchar(255) DEFAULT NULL,
  `stock_name` varchar(50),
   PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE `stock_daily_record` (
   `stock_daily_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
   `price_open` varchar(255),
  `price_close` varchar(10),
  `price_change` varchar(10),
  `volume` bigint(10),
  `date` timestamp,
  `stock_id` bigint(20),
   PRIMARY KEY (`stock_daily_record_id`),
   CONSTRAINT `fk_stock_id` foreign key (`stock_id`) references `stock`(`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


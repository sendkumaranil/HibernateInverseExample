package com.hibernate.inverseexample.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.inverseexample.model.Stock;
import com.hibernate.inverseexample.model.StockDailyRecord;
import com.hibernate.inverseexample.util.HibernateUtil;

public class TestHibernateInverseExample {

	public static void main(String[] args) {
		
		insertingRecord();
		updatingrecord();
	}
	
	public static void insertingRecord(){
		Stock stock=new Stock();
		stock.setStock_code("9005");
		stock.setStock_name("TATA");
		
		StockDailyRecord stockDailyrecord=new StockDailyRecord();
		stockDailyrecord.setPriceOpen("425.12");
		stockDailyrecord.setPriceClose("527.25");
		stockDailyrecord.setPriceChange("102.13");
		stockDailyrecord.setVolume(4000);
		stockDailyrecord.setDate(new Date());
		
		stockDailyrecord.setStock(stock);
		stock.getStockDailyRecords().add(stockDailyrecord);
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		
		try{
			sessionFactory=HibernateUtil.getSessionfactory();
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(stock);
			session.save(stockDailyrecord);
			
			tx.commit();
			session.flush();
			
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			if(session!=null)session.close();
		}
	}
	
	public static void updatingrecord(){
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		
		try{
			sessionFactory=HibernateUtil.getSessionfactory();
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			Stock stock=(Stock)session.get(Stock.class, 11);
			
			StockDailyRecord stockDailyrecord=new StockDailyRecord();
			stockDailyrecord.setPriceOpen("100.2");
			stockDailyrecord.setPriceClose("110.1");
			stockDailyrecord.setPriceChange("10.0");
			stockDailyrecord.setVolume(3000);
			stockDailyrecord.setDate(new Date());
			
			stockDailyrecord.setStock(stock);
			stock.getStockDailyRecords().add(stockDailyrecord);
			
			session.save(stockDailyrecord);
			session.update(stock);
			
			session.flush();
			tx.commit();
			
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			if(session!=null)session.close();
		}
	}
}

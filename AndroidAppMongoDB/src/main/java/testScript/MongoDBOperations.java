package testScript;
import org.bson.Document;
import org.testng.annotations.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBOperations extends BaseClass{

	@Test
	public void InsetAndFetchDoc()
	{
		try {
			
			String orderNumber = getDateTime();
			String product= productName;
			String amount = productAmount;
			
			
			//Connect to MongoDB 
			MongoClient mongodb = new MongoClient("localhost", 27017);

			//Select Database from MongoDB
			DB db = mongodb.getDB("userdetails");

			//Get specific 
			DBCollection coll = db.getCollection("orderDetails1");
			System.out.println("Collection selected successfully.");
			
			//Add Document into collection.
			DBObject dbObject = new BasicDBObject("orderId", orderNumber)
								.append("productName", product)
								.append("amount", amount);
			
			//Insert document in collection.
			coll.insert(dbObject);
			System.out.println("Document Added successfully.");
			
			//Create query to select specific document.
		    BasicDBObject whereQuery = new BasicDBObject();
		    whereQuery.put("orderId", orderNumber);
		    
		    
		    //Find document w.r.t. OrderId column.
			DBCursor cursor = coll.find(whereQuery);

			while (cursor.hasNext()) 
			{
				//Print matched document.
				System.out.println(cursor.next());
				
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Error is :-" + e.getMessage());
		}
	}
}
package Launch;

import com.salesforce.oauth.SalesforceAuth;

public class Entry {

	public static void main(String[] args) {
		 final String CONSUMER_KEY = "3MVG9rZjd7MXFdLj4SPjUucdAc7W8cgh_6TKjAbC7QlIiJFKr.nmUWPFUqVLafE36yxNWV1ccWGuKULHDoDph";
		    final String CONSUMER_SECRET = "03A8CFA9E9941610B67BE93A5E0DDC4A9C6B550E1CA924A882CCAAF5C1BB3DB3";    
			SalesforceAuth auth = new SalesforceAuth(CONSUMER_KEY, CONSUMER_SECRET, false);
			System.out.println(auth.start());

	}

}

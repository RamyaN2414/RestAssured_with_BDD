Feature: RestAssured with BDD Cucumber
	Scenario: End to End API Testing with API framework Automation
		
		Given User Hit API with Post Request method then new resource created including id
		
		When Use Hit with Get Request method to retrive retrive resource through previously generated id
		
		And Use Hit Api with Put method to modify resource through same generated id
		
		Then User Hit Api with Delete method to delete that record
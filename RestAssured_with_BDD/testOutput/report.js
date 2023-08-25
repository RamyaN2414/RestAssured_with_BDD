$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:/D:/Java/RestAssured_with_BDD/Features/FeaturesFile.feature");
formatter.feature({
  "name": "RestAssured with BDD Cucumber",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "End to End API Testing with API framework Automation",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User Hit API with Post Request method then new resource created including id",
  "keyword": "Given "
});
formatter.match({
  "location": "User_test_Stepdefination.user_Hit_API_with_Post_Request_method_then_new_resource_created_including_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Use Hit with Get Request method to retrive retrive resource through previously generated id",
  "keyword": "When "
});
formatter.match({
  "location": "User_test_Stepdefination.use_Hit_with_Get_Request_method_to_retrive_retrive_resource_through_previously_generated_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Use Hit Api with Put method to modify resource through same generated id",
  "keyword": "And "
});
formatter.match({
  "location": "User_test_Stepdefination.use_Hit_Api_with_Put_method_to_modify_resource_through_same_generated_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Hit Api with Delete method to delete that record",
  "keyword": "Then "
});
formatter.match({
  "location": "User_test_Stepdefination.user_Hit_Api_with_Delete_method_to_delete_that_record()"
});
formatter.result({
  "status": "passed"
});
});
Feature: Validating Place API's

Scenario: Verify if place is being successfully added using AddPlace API
Given Add Place Payload 
When user calls "AddPlaceAPI"  with Post Http request 
Then  the API call got success with status code 
And "status"  in the response body is "OK"
And "scope"  in the response body is "APP"

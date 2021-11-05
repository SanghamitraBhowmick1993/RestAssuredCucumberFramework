Feature: Validating Place API's

@Addplace
Scenario Outline: Verify if Place is successfully added using AddPlace API
Given add Place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "Post" HTTP Request
Then the API call is success with status code 200
#And "Status" in response body is "OK"
#And "Scope" in response body is "APP"
And verify place_id created maps to "<name>" using "GetPlaceAPI"
  

Examples:
	|name    | language | address |
	|AAHouse | French   | World Trade Centre |
#	|New House | English   | New Trade Centre |


@DeletePlace
Scenario: Verify if Delete place functionality is working
Given DeletePlace Payload
When user calls "DeletePlaceAPI" with "Post" HTTP Request
Then the API call is success with status code 200
#And "Status" in response body is "OK"
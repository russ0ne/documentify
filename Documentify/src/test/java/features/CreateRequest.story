Sample story

# Narrative: In order to test the submission flow As a member of the open source project I want to create a request for documentation

Scenario:  Creating request no. 1
Given a task of creating a new request
When a Title is Test_Request1, Description is 'Test_Desc', Request Date is '01/01/2014', Due Date is '01/01/2017', Points Avilable is '28', Priority is 'Low', Status is 'Open', Requested By 'Russ', Comments is 'Test_Comment'
Then a Requst the request with identical parameters can retreived. 

Feature: Sample product api test

Background: 
Given set baseURL "https://fakestoreapi.com"

@tag1
Scenario: validate the products

Given set basePath "/products/1"
When set headers
|Content-Type|application/json|
And click getsend
Then validate the statuscode 200
Then validate the response "response"
Then validate the ID "1" as "id"
Then validate the Title "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops" as "title"
Then validate the Price "109.95" as "price"
Then and teardown


@tag2
Scenario: validate the postproduct
Given set basePath "/products"
When set headers 
|Content-Type|application/json|
And set inputpayload "C:\Users\Vishnu\eclipse-workspace\API_cucumber_product\src\product.json"
And click postsend
Then validate the statuscode 201
Then validate the response "response"
Then validate the ID "21" as "id"
Then validate the Title "New Product" as "title"
Then validate the Price "29.99" as "price"
Then and teardown

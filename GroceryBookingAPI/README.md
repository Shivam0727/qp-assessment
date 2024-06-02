# Grocery Booking Application

This project is a Spring Boot application for managing grocery bookings. It provides APIs for both admin and user operations such as adding, updating, and viewing groceries, as well as placing orders. The application is containerized using Docker for ease of deployment and scaling.

## Project Structure

```
grocery-booking/
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── grocerybooking
│   │   │               ├── GroceryBookingApplication.java
│   │   │               ├── controller
│   │   │               │   ├── AdminController.java
│   │   │               │   └── UserController.java
│   │   │               ├── model
│   │   │               │   ├── GroceryItem.java
│   │   │               │   ├── Order.java
│   │   │               │   └── OrderItem.java
│   │   │               ├── repository
│   │   │               │   ├── GroceryItemRepository.java
│   │   │               │   ├── OrderItemRepository.java
│   │   │               │   └── OrderRepository.java
│   │   │               └── service
│   │   │                   ├── GroceryService.java
│   │   │                   └── OrderService.java
│   ├── resources
│   │   ├── static
│   │   ├── templates
│   │   │   ├── index.html
│   │   │   ├── admin.html
│   │   │   ├── admin-add-grocery.html
│   │   │   ├── admin-view-groceries.html
│   │   │   └── user-view-groceries.html
│   │   └── application.properties
├── Dockerfile
└── docker-compose.yml
```

## Prerequisites

- Docker
- Docker Compose

# Getting Started

### Build the Docker Image

Navigate to the root directory of the project and run the following command to build the Docker image:

```sh
docker-compose build
```

### Run the Docker Containers

Start the application and the database using Docker Compose:

```sh
docker-compose up
```

### Access the Application

Open your web browser and go to `http://localhost:8080` to access the Grocery Booking application.

# API Endpoints

### Admin Endpoints


- **Add Grocery Item**
  - **URL**: `/admin/groceries`
  - **Method**: `POST`
  - **Request Body**: JSON representation of the grocery item
  - **Response**: The created grocery item

** Example Request : **

	{
	  "name": "Apple",
	  "price": 1.50,
	  "inventory": 100
	}
  	
** Example Response : ** 

	{	
		"id": 1,
		"name": "Apple",
		"price": 1.50,
		"inventory": 100		
	}


- **Get All Groceries**
  - **URL**: `/admin/groceries`
  - **Method**: `GET`
  - **Response**: List of all grocery items

** Example Response : **

	[
		{
    		"id": 1,
    		"name": "Apple",
    		"price": 1.50,
    		"inventory": 100
		},	
	   {
    		"id": 2,
    		"name": "Banana",
    		"price": 0.75,
    		"inventory": 150
		}		
	]
	

- **Delete Grocery Item**
  - **URL**: `/admin/groceries/{id}`
  - **Method**: `DELETE`
  - **Response**: None



- **Update Grocery Item**
  - **URL**: `/admin/groceries/{id}`
  - **Method**: `PUT`
  - **Request Body**: JSON representation of the updated grocery item
  - **Response**: The updated grocery item


** Example Request : **

	{
	  "name": "Apple",
	  "price": 2.50,
	  "inventory": 150
	}
  	
** Example Response : **

	{	
		"id": 1,
		"name": "Apple",
		"price": 2.50,
		"inventory": 150		
	}
	

- **Update Grocery Inventory**
  - **URL**: `/admin/groceries/{id}/inventory`
  - **Method**: `PATCH`
  - **Request Body**: Integer representing the new inventory
  - **Response**: The updated grocery item

** Example Request : **

	{
	  "inventory": 200
	}
	
	OR
	
	200
  	
** Example Response : **

	{	
		"id": 1,
		"name": "Apple",
		"price": 1.50,
		"inventory": 200		
	}


### User Endpoints


- **Get All Groceries**
  - **URL**: `/user/groceries`
  - **Method**: `GET`
  - **Response**: List of all grocery items

** Example Response : **

	[
		{
    		"id": 1,
    		"name": "Apple",
    		"price": 1.50,
    		"inventory": 100
		},	
	   {
    		"id": 2,
    		"name": "Banana",
    		"price": 0.75,
    		"inventory": 150
		}		
	]
	


- **Create Order**
  - **URL**: `/user/orders`
  - **Method**: `POST`
  - **Request Body**: JSON representation of the order
  - **Response**: The created order

** Example Request : **

	{
	  "userId": 1,
	  "orderDate": "2023-05-01T12:00:00Z",
	  "items": [
	    {
		   "groceryId": 1,
	      "quantity": 5
		 },
	    {
		   "groceryId": 2,
	      "quantity": 10
		 }
	  ]
	}
	
** Example Response : **

	{
	  "id": 1,
	  "userId": 1,
	  "orderDate": "2023-05-01T12:00:00Z",
	  "items": [
		 {
	      "id": 1,
	      "groceryId": 1,
	      "quantity": 5
	    },
	    {
	      "id": 2,
	      "groceryId": 2,
	      "quantity": 10
	    }
	  ]
	}



## Exception Handling

Global exception handling is implemented using `ControllerAdvice`. Custom exceptions are defined for handling specific error cases.

## Database Configuration

The application uses a MySQL database. The database configuration can be found in the `application.properties` file. When running the application with Docker, the database connection details are provided via environment variables in the `docker-compose.yml` file.

## Docker Configuration

### Dockerfile

The `Dockerfile` is a multi-stage build that compiles the application using Maven and then packages it in a lightweight OpenJDK image.

### docker-compose.yml

The `docker-compose.yml` file defines two services: the application (`app`) and the database (`db`). The application service depends on the database service to ensure the database is started before the application.


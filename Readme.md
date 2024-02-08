# Weather Controller

## Description

This controller provides endpoints to fetch weather forecasts based on location names. It utilizes external weather services via RapidAPI and requires authentication using client ID and client secret.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Authentication](#authentication)
- [Dependencies](#dependencies)
- [Initialization](#initialization)
- [Error Handling](#error-handling)
- [Contributing](#contributing)

## Installation

Run this project with below script
                
    mvn spring-boot:run

## Usage

This controller can be used to retrieve weather forecasts for specific locations via HTTP requests to the provided endpoints.

## Endpoints

### 1. Get Forecast Summary by Location Name

- **Endpoint:** `/RapidApiGetForecastSummaryByLocationName`
- **Method:** GET
- **Description:** Fetches weather forecast summary for a specified location.
- **Parameters:**
    - `city` (String, required): Name of the city for which weather forecast is requested.
- **Headers:**
    - `Client-ID` (String, required): Client ID for authentication.
    - `Client-Secret` (String, required): Client secret for authentication.
- **Response:**
    - `200 OK`: Returns the weather forecast summary for the specified location.
    - `401 Unauthorized`: If authentication fails.

### 2. Get Hourly Forecast by Location Name

- **Endpoint:** `/hourly-forecast`
- **Method:** GET
- **Description:** Fetches hourly weather forecast for a specified location.
- **Parameters:**
    - `city` (String, required): Name of the city for which hourly weather forecast is requested.
- **Headers:**
    - `Client-ID` (String, required): Client ID for authentication.
    - `Client-Secret` (String, required): Client secret for authentication.
- **Response:**
    - `200 OK`: Returns the hourly weather forecast for the specified location.
    - `401 Unauthorized`: If authentication fails.

## Authentication

Both endpoints require authentication using client ID and client secret passed through request headers.

## Dependencies

- **WeatherService:** This controller relies on a `WeatherService` implementation to fetch weather forecasts.
- **RapidAPI:** External weather service is accessed via RapidAPI, and the API key is provided through application properties.

## Initialization

The `WeatherController` is initialized with a `WeatherService` instance and the RapidAPI key injected from the application properties.

## Error Handling

- If authentication fails, a `401 Unauthorized` response is returned.
- Any exceptions during JSON processing are caught and handled gracefully, returning an appropriate error response.


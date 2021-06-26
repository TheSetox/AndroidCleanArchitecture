# AndroidCleanArchitecture
Template for using Clean Architecture Concepts in Android

![clean_architecture_vertical_onion](https://user-images.githubusercontent.com/22768492/123507268-0fe6f000-d69b-11eb-9cbd-95d221198180.png)

## We have separated the layers into three main group
- Presentation/App - It includes the UI layer and ViewModel.
- Domain - Holds all the UseCase, Entities and the Interface of the Repository. This is will be use as the Business Logic of the App.
- Data - Abstract definition of all the data sources and the data source. Ex. Repository, Local Database and Remote API.

Here is another diagram how the data flow in the app:

![clean_architecture_vertical-template1](https://user-images.githubusercontent.com/22768492/123505618-c4304880-d692-11eb-8011-e611eb657537.png) 

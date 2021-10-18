## EY_Fruits

EY Fruits application is a two-page mobile fruit application detailing the necessary information for the food and fruits in the attached Json file. 
The page one contains a RecyclerView that displays all the fruits in the JSON file alongside their Images, their nutrients and their origin. The page two 
contains more information about the selected fruit in page one. There are also images of food stored in Cloudinary and then displayed in the page two.

## JSON file from which fruit informations are fetched.

```yaml
[
  {
    "id": 0,
    "productName": "Fresh Avocados",
    "image": "🥑",
    "from": "Spain",
    "nutrients": "Vitamin B, Vitamin K",
    "quantity": "4 🥑",
    "price": "6.50",
    "organic": true,
    "description": "A ripe avocado yields to gentle pressure when held in the palm of the hand and squeezed. The fruit is not sweet, 
    but distinctly and subtly flavored, with smooth texture. The avocado is popular in vegetarian cuisine as a substitute for meats 
    in sandwiches and salads because of its high fat content. Generally, avocado is served raw, though some cultivars, including the common 'Hass', 
    can be cooked for a short time without becoming bitter. It is used as the base for the Mexican dip known as guacamole, as well as a spread on corn 
    tortillas or toast, served with spices."
  },
  {
    "id": 1,
    "productName": "Goat and Sheep Cheese",
    "image": "🧀",
    "from": "Portugal",
    "nutrients": "Vitamin A, Calcium",
    "quantity": "250g",
    "price": "5.00",
    "organic": false,
    "description": "Creamy and distinct in flavor, goat cheese is a dairy product enjoyed around the world. Goat cheese comes in a wide variety of flavors and
    textures, from soft and spreadable fresh cheese to salty, crumbly aged cheese. Although it’s made using the same coagulation and separation process as cheese
    made from cow’s milk, goat cheese differs in nutrient content."
  },
  {
    "id": 2,
    "productName": "Apollo Broccoli",
    "image": "🥦",
    "from": "Portugal",
    "nutrients": "Vitamin C, Vitamin K",
    "quantity": "3 🥦",
    "price": "5.50",
    "organic": true,
    "description": "Broccoli is known to be a hearty and tasty vegetable which is rich in dozens of nutrients. It is said to pack the most nutritional punch of any
    vegetable. When we think about green vegetables to include in our diet, broccoli is one of the foremost veggies to come to our mind. Broccoli is a cruciferous
    vegetable and part of the cabbage family, which includes vegetables such as Brussel sprouts and kale. Although the tastes are different, broccoli and these
    other vegetables are from the same family."
  },
  {
    "id": 3,
    "productName": "Baby Carrots",
    "image": "🥕",
    "from": "France",
    "nutrients": "Vitamin A, Vitamin K",
    "quantity": "20 🥕",
    "price": "3.00",
    "organic": true,
    "description": "The carrot is a root vegetable that is often claimed to be the perfect health food. It is crunchy, tasty and highly nutritious. Carrots are a
    particularly good source of beta-carotene, fiber, vitamin K, potassium and antioxidants. Carrots have a number of health benefits. They are a weight loss
    friendly food and have been linked to lower cholesterol levels and improved eye health."
  },
  {
    "id": 4,
    "productName": "Sweet Corncobs",
    "image": "🌽",
    "from": "Germany",
    "nutrients": "Vitamin C, Magnesium",
    "quantity": "2 🌽",
    "price": "2.00",
    "organic": false,
    "description": "Also known as maize, corn is one of the most popular cereal grains in the world. Popcorn and sweet corn are commonly eaten varieties, but
    refined corn products are also widely consumed, frequently as ingredients in foods. These include tortillas, tortilla chips, polenta, cornmeal, corn flour, 
    corn syrup, and corn oil. Whole-grain corn is as healthy as any cereal grain, rich in fiber and many vitamins, minerals, and antioxidants."
  }
]
```

## Technologies built with
EY Fruit App Codebase is designed to enable easy flow and collaboration among android native developers of all experiences, yet leveraging latest standards, architecture and best practces. Below and many more are the technologies that would be used. 

* Kotlin - The programming language used
* Model View Controller (MVC) - Design Pattern
* Glide - External library used to load images from the cloud provider. 
* Cloudinary - Cloud storage for saving images
* Jetpack viewBinding
* And many more.

## Contribution

This Codebase is entirely developed by Ayotola Moronkeji, Android Engineer. 

Follow the steps below to contribute

- Fork the project
- Open the forked project
- Clone the forked project from your repo by following the steps below
    - Copy the HTTPS or SSH link
    - Open you terminal and type `git clone <link>`
- Navigate to the cloned directory `cd <directory name>`
- Check that your fork is the origin remote `git remote -v`
- Add the project repository as the upstream remote `git remote add upstream PROJECT_URL`
- Create a new branch `git checkout -b BRANCH_NAME`
- Make changes in your local repository
- Use `git add -A` to stage your changes and `git commit -m "DESCRIPTION OF CHANGES"` to commit them.
- When you are done making all of your changes, upload these changes to your fork using `git push origin BRANCH_NAME`.

### Naming Convention
- When naming a fragment or activity class, use `NameActivity.kt` or `NameFragment.kt` E.g `EyFruitActivity.kt`
- When naming a framgment or activity layout, use `activity_name.xml` or `fragment_name.xml` E.g `activity_main.xml`
- When naming any other layout, use `name_layout.xml` E.g `item_layout.xml`

<!-- ## Screen Shots

<img width="326" alt="Screen Shot of the first page of the EY Fruit App" src="https://user-images.githubusercontent.com/27390903/137527213-bdad261a-683d-43f4-9b81-cf9ed40a945b.png"> | <img width="326" alt="Screen Shot of the second page of the EY Fruit App" src="https://user-images.githubusercontent.com/27390903/137527269-20ee5071-72ca-420b-ae34-6a252bc54c4b.png"> -->



package com.yerirang27.natureapp

object QuizBank {

    val currentQuestion: Quiz
        get() = questions[currentIndex]
    var currentIndex = 0
    private lateinit var questions: List<Quiz>

    fun createQuizBank() {
        questions = listOf(
            Quiz(
                image = "https://www.finedininglovers.com/sites/g/files/xknfdk626/files/styles/article_1200_800_fallback/public/Original_8472_banana-peel.jpg?itok=IY-hrSV1",
                contentDescription = "Banana peel",
                answer = "Compost",
            ),
            Quiz(
                image = "https://www.miheuprecision.com/images/blog/pet-bottle-recycling.jpg",
                contentDescription = "Plastic bottle",
                answer = "Recycle",
            ),
            Quiz(
                image = "https://www.grangerwasteservices.com/wp-content/uploads/2023/10/iStock-1147024409-600x400.jpg",
                contentDescription = "Candy wrappers",
                answer = "Trash",
            ),
            Quiz(
                image = "https://www.grangerwasteservices.com/wp-content/uploads/2023/10/iStock-1147024409-600x400.jpg",
                contentDescription = "Candy wrappers",
                answer = "Trash",
            ),
            Quiz(
                image = "https://img.freepik.com/premium-photo/two-squeezed-soda-cans-isolated-white-background-recycling-recycling-concept_300903-1907.jpg",
                contentDescription = "Soda cans",
                answer = "Recycle",
            ),
            Quiz(
                image = "https://www.cleanindiatech.com/blog/wp-content/uploads/2021/01/1598273574.jpg",
                contentDescription = "Leftover food",
                answer = "Compost",
            ),
            Quiz(
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlBJrv6z6L3ixesiVIZcOoPfzCrQmS0IsE3A&s",
                contentDescription = "Paper",
                answer = "Recycle",
            ),
            Quiz(
                image = "https://www.nutraingredients-asia.com/var/wrbm_gb_food_pharma/storage/images/_aliases/wrbm_large/3/4/5/4/3854543-7-eng-GB/Egg-shell-powder-a-novel-treatment-against-inflammatory-bowel-disease.jpg",
                contentDescription = "Egg shells",
                answer = "Compost",
            ),
            Quiz(
                image = "https://m.media-amazon.com/images/I/713wHFXZ41L.jpg",
                contentDescription = "Pizza box",
                answer = "Compost",
            ),
            Quiz(
                image = "https://1d81e75c4337a6e2e3c2-4a69748413de5fcbd7a7a944817c2356.ssl.cf1.rackcdn.com/375004073_videos/202309142051071786007619.png",
                contentDescription = "Paper Napkins",
                answer = "Compost",
            ),
            Quiz(
                image = "https://www.shutterstock.com/image-vector/dog-poop-plastic-bag-vector-600nw-2150405669.jpg",
                contentDescription = "Pet waste",
                answer = "Trash",
            ),
            Quiz(
                image = "https://i.ebayimg.com/images/g/MuoAAOSwKwBbFvKo/s-l1200.jpg",
                contentDescription = "Plastic utensil",
                answer = "Trash",
            ),
            Quiz(
                image = "https://cdnimg.webstaurantstore.com/images/products/large/47679/2404857.jpg",
                contentDescription = "Foam containers",
                answer = "Trash",
            ),
            Quiz(
                image = "https://www.historic-newspapers.com/wp-content/uploads/sites/6/2023/11/untitled-design-8.jpg?w=1000",
                contentDescription = "Newspaper",
                answer = "Recycle",
            ),
            Quiz(
                image = "https://hips.hearstapps.com/hmg-prod/images/index-paperback-6542ab16cd89d.jpg?crop=0.5xw:1xh;center,top&resize=640:*",
                contentDescription = "Paperback books",
                answer = "Recycle",
            ),
            Quiz(
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS77j40tGEa_q6Gz1PoGF18MDs9YjRj70kRYg&s",
                contentDescription = "Hardback books",
                answer = "Trash",
            ),




        )
    }
}

data class Quiz(
    val image: String,
    val contentDescription: String,
    val answer: String,
)
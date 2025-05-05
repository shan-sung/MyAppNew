package com.example.myapp.data

import com.example.myapp.R
import com.example.myapp.data.model.Trip
import com.example.myapp.data.model.City
import com.example.myapp.data.model.Location
import com.example.myapp.data.model.DayPlan
import com.example.myapp.data.model.AttractionPlan
import com.example.myapp.data.model.User
import java.time.LocalDate

object Datasource {

    fun loadHotTrips(): List<Trip> {
        return listOf(
            Trip(
                id = "hotTrip_1",
                name = "Hot trip 1",
                members = listOf("Alice", "Bob"),
                budget = 10000,
                startDate = LocalDate.parse("2025-05-01"),
                endDate = LocalDate.parse("2025-05-03"),
                note = "null",
                dailyPlans = listOf(
                    DayPlan(
                        day = 1,
                        attractions = listOf(
                            AttractionPlan(time = "08:00~09:00", name = "Hot 1", type = "eat"),
                            AttractionPlan(time = "10:00~11:30", name = "Hot 2", type = "walk"),
                            AttractionPlan(time = "12:00~13:00", name = "Hot 3", type = "eat")
                        )
                    ),
                    DayPlan(
                        day = 2,
                        attractions = listOf(
                            AttractionPlan(time = "09:00~11:00", name = "故宮博物院", type = "walk"),
                            AttractionPlan(time = "12:00~13:00", name = "士林夜市", type = "eat"),
                            AttractionPlan(time = "14:00~16:00", name = "陽明山", type = "walk")
                        )
                    ),
                    DayPlan(
                        day = 3,
                        attractions = listOf(
                            AttractionPlan(time = "10:00~11:00", name = "象山登山步道", type = "walk"),
                            AttractionPlan(time = "12:00~13:00", name = "饒河夜市", type = "eat")
                        )
                    )
                )
            ),
            Trip(
                id = "hotTrip_2",
                name = "Hot trip 2",
                members = listOf("Charlie", "David", "Bob"),
                budget = 10000,
                startDate = LocalDate.parse("2025-05-03"),
                endDate = LocalDate.parse("2025-05-09"),
                note = "好期待",
                dailyPlans = listOf(
                    DayPlan(
                        day = 1,
                        attractions = listOf(
                            AttractionPlan(time = "08:00~09:00", name = "Hot 1", type = "eat"),
                            AttractionPlan(time = "10:00~11:30", name = "Hot 2", type = "walk"),
                            AttractionPlan(time = "12:00~13:00", name = "Hot 3", type = "eat")
                        )
                    ),
                    DayPlan(
                        day = 2,
                        attractions = listOf(
                            AttractionPlan(time = "09:00~11:00", name = "故宮博物院", type = "walk"),
                            AttractionPlan(time = "12:00~13:00", name = "士林夜市", type = "eat"),
                            AttractionPlan(time = "14:00~16:00", name = "陽明山", type = "walk")
                        )
                    ),
                    DayPlan(
                        day = 3,
                        attractions = listOf(
                            AttractionPlan(time = "10:00~11:00", name = "象山登山步道", type = "walk"),
                            AttractionPlan(time = "12:00~13:00", name = "饒河夜市", type = "eat")
                        )
                    )
                )
            ),
            )
    }

    fun loadCities(): List<City> {
        return listOf(
            City("1", R.drawable.image1, R.string.taipei),
            City("2", R.drawable.image1, R.string.new_taipei),
            City("3", R.drawable.image1, R.string.keelung),
            City("4", R.drawable.image1, R.string.taoyuan),
            City("5", R.drawable.image1, R.string.taichung),
            City("6", R.drawable.image1, R.string.tainan),
            City("7", R.drawable.image1, R.string.kaohsiung),
            City("8", R.drawable.image1, R.string.pingtung),
            City("9", R.drawable.image1, R.string.hsinchu),
            City("10", R.drawable.image1, R.string.yilan),
            City("11", R.drawable.image1, R.string.hualien),
            City("12", R.drawable.image1, R.string.chiayi),
            City("13", R.drawable.image1, R.string.taitung),
        )
    }

    fun loadTrip(): List<Trip> {
        return listOf(
            Trip(
                id = "1",
                name = "台北探索之旅",
                members = listOf("Alice", "Bob", "Charlie"),
                budget = 10000,
                startDate = LocalDate.parse("2025-05-01"),
                endDate = LocalDate.parse("2025-05-03"),
                note = "三天兩夜吃吃喝喝行程",
                dailyPlans = listOf(
                    DayPlan(
                        day = 1,
                        attractions = listOf(
                            AttractionPlan(time = "08:00~09:00", name = "永和豆漿", type = "eat"),
                            AttractionPlan(time = "10:00~11:30", name = "101大樓", type = "walk"),
                            AttractionPlan(time = "12:00~13:00", name = "鼎泰豐", type = "eat")
                        )
                    ),
                    DayPlan(
                        day = 2,
                        attractions = listOf(
                            AttractionPlan(time = "09:00~11:00", name = "故宮博物院", type = "walk"),
                            AttractionPlan(time = "12:00~13:00", name = "士林夜市", type = "eat"),
                            AttractionPlan(time = "14:00~16:00", name = "陽明山", type = "walk")
                        )
                    ),
                    DayPlan(
                        day = 3,
                        attractions = listOf(
                            AttractionPlan(time = "10:00~11:00", name = "象山登山步道", type = "walk"),
                            AttractionPlan(time = "12:00~13:00", name = "饒河夜市", type = "eat")
                        )
                    )
                )
            )
        )
    }

    fun loadAttr(): List<Location> {
        return listOf(
            Location(
                id = "1",
                imageResId = R.drawable.image1,
                stringResourceId = R.string.attr_1,
                title = "attr1",
                details = "my warm day, good good, good",
                cityId = "1"
            ),
            Location(
                id = "2",
                imageResId = R.drawable.image1,
                stringResourceId = R.string.attr_2,
                title = "my台中美食行",
                details = "taichung good, yummy, yummy, yummy",
                cityId = "5"
            )
        )
    }

    fun loadUser(): List<User> {
        return listOf(
            User(
                name = "Shan",
                email = "Shan123@gmail.com",
                gender = "Female",
                birthday = LocalDate.parse("2004-02-25"),
                mbti = "",
                avatarUrl = ""
            )
        )
    }
}
import com.cityhospital.backend.Comment
import com.cityhospital.backend.Doctor
import com.cityhospital.backend.DoctorCategory
import com.cityhospital.backend.HospitalInfo

/**
 * Created by Slawa on 03.05.2016.
 */
class BootStrap {

    def randomUsersService

    def init = { servletContext ->
        new HospitalInfo(
                title: "More About Our Agency.",
                about: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.\n" +
                        "\n" +
                        "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                        "\n" +
                        "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source."
        ).save(false)
        def categories = ["Cardiology", "Dietology", "Hematology"]
        categories.each {
            def category = new DoctorCategory(name: it).save(false)
            for (i in 0..<10) {
                def randomUser = randomUsersService.fetchNewRandomUser()
                new Doctor(
                        name: randomUser.name,
                        picture: randomUser.picture,
                        category: category
                ).save(false)
            }
        }
        new Comment(
                username: "Vlad",
                picture: randomUsersService.fetchNewRandomUser().picture,
                title: "Awesome title",
                body: "A lot of text inside this comment!"
        ).save(false)
    }
    def destroy = {
    }
}

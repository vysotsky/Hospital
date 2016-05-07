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
                about: "A hospital is a health care institution providing patient treatment with specialized staff and equipment. The best-known type of hospital is the general hospital, which has an emergency department. A district hospital typically is the major health care facility in its region, with large numbers of beds for intensive care and long-term care. Specialised hospitals include trauma centres, rehabilitation hospitals, children's hospitals, seniors' (geriatric) hospitals, and hospitals for dealing with specific medical needs such as psychiatric problems (see psychiatric hospital) and certain disease categories. Specialised hospitals can help reduce health care costs compared to general hospitals.\n" +
                        "\n" +
                        "A teaching hospital combines assistance to people with teaching to medical students and nurses. The medical facility smaller than a hospital is generally called a clinic. Hospitals have a range of departments (e.g.: surgery and urgent care) and specialist units such as cardiology. Some hospitals have outpatient departments and some have chronic treatment units. Common support units include a pharmacy, pathology, and radiology.\n" +
                        "\n" +
                        "Hospitals are usually funded by the public sector, by health organisations (for profit or nonprofit), by health insurance companies, or by charities, including direct charitable donations. Historically, hospitals were often founded and funded by religious orders or charitable individuals and leaders."
        ).save(false)
        def categories = ["Cardiology", "Dietology", "Hematology"]
        categories.each {
            def category = new DoctorCategory(name: it).save(false)
            for (i in 0..<8) {
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

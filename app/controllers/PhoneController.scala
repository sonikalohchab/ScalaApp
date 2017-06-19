package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.Json

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class PhoneController @Inject() extends Controller {
  
  case class Phone(id:Int, areacode:Int, number:Int)
  
  var phoneNums=List(
      Phone(1,858,1234567),
      Phone(2,619,3456789),
      Phone(3,760,2134356)
      );
  
  implicit val phoneNumbers=Json.writes[Phone];
  
  def all= Action{
    val json = Json.toJson(phoneNums);
    Ok(json);
    
  }
  
  /* I didn;t have enough time to understand and do post action
  def create= Action.async(parse.json) { request =>
    request.body.validate[Phone].map {
      phone =>
        collection.insert(phone).map {
          lastError => Created(s"Phone Created")
        }
    }.getOrElse(Future.successful(BadRequest("invalid json")))
  }*/
  
  def show(id:Long)= Action{
    var phone=phoneNums.filter(_.id==id)
    val json = Json.toJson(phone);
    Ok(json);
    
  }
  
  /*Need to parse JSOn, couldn't able to do it
  def update(id:Long)= Action{
    var phone=phoneNums.filter(_.id==id)
    val json = Json.toJson(phoneNums);
    Ok(json);
    
  }*/
  
  def delete(id:Long)= Action{
    var phone=phoneNums.filterNot(_.id==id)
    val json = Json.toJson(phone);
    Ok(json);
    
  }
    

  
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { implicit request =>
    Ok(views.html.index())
  }
}

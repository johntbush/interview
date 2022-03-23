package godaddy;

public class UserRegistration {
  private String firstName;
  private String lastName;
  private Integer id;
  private Integer age;

  public UserRegistration() {
  }

  public UserRegistration(String firstName, String lastName, Integer id, Integer age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}

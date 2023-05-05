# 코루틴 + 스프링 이벤트 버스 예시

## 사용 예시

### 이벤트 발행

```kotlin
@Service
class UserService(
    private val userRepository: UserRepository,
    private val userEventBus: CoroutineEventBus,
) {

    suspend fun createUser(userRequest: UserRequest) {

        val user = User(name = userRequest.name, email = userRequest.email)
        userRepository.save(user)

        userEventBus.post(UserCreated(user))
    }
}

data class UserCreated(val user: User)
```

### 이벤트 수신

```kotlin
@Component
class EmailSender : EventSubscriber<UserCreated> {

    val log = LoggerFactory.getLogger(this.javaClass)

    override fun onEvent(event: UserCreated) {

        log.info("sending email to ${event.user.email}")
    }

}
```
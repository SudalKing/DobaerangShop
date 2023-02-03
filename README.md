# User - Authority


## 📌 User-Authority
- User와 Authority 관계

![model](https://user-images.githubusercontent.com/87001865/216620146-f15bd99d-8587-4f64-b9ee-a5d194d7990b.png)



<br>

## 📌 UserService class
- User와 user의 권한을 설정하는 UserService

### 1. [saveUser] 
- 기본 권한인 "ROLE_USER"와 함께 User 정보를 저장

![saveUser](https://user-images.githubusercontent.com/87001865/216394223-f3cf5752-9849-47c4-90ec-c4f8196efbd7.png)

#### - [saveUserTest]
![saveUserTest](https://user-images.githubusercontent.com/87001865/216394421-90556888-b316-4101-bc8e-abf2f6cd56be.png)

#### - [결과]
![saveUserResult](https://user-images.githubusercontent.com/87001865/216615222-2b55feef-3671-4cfa-9ec6-22680f937fde.png)

<br>

### 2. [addAuthority] 
- "ROLE_USER" 이외의 권한을 추가

![addAuthority](https://user-images.githubusercontent.com/87001865/216616051-345cee75-8b50-4c5e-85e1-58fecbd474db.png)

#### - [addAuthorityTest]
![addAuthorityTest](https://user-images.githubusercontent.com/87001865/216616154-f28beacc-d047-4da3-87a6-9bae49a1f8a2.png)

#### - [결과]
![addAuthorityResult](https://user-images.githubusercontent.com/87001865/216616342-48408199-40d4-4c19-b6ef-cc76a08120a9.png)

<br>

### 3. [denyUser] 
- 'enabled' = false 를 통해 유저를 차단

![denyUser](https://user-images.githubusercontent.com/87001865/216616973-0060f550-946a-40aa-8541-b1c5711df767.png)

#### - [denyUserTest]
![denyUserTest](https://user-images.githubusercontent.com/87001865/216617003-24a3c117-6fa5-4c3f-95db-c6c6f9ff15f9.png)

#### - [결과]
![denyUserResult](https://user-images.githubusercontent.com/87001865/216619717-eaf1505d-b6b4-43ce-87f0-619281933487.png)



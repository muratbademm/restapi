# RestAPI Project

Bu proje, **Spring Boot** kullanılarak geliştirilmiş bir **Katmanlı REST API** uygulamasıdır. 
MySQL veritabanı üzerinde temel CRUD işlemleri sağlar. 
Domain olarak **Kategori**, **Ürün**, **Tedarikçi** yönetimi yapılmaktadır.

---

## ✨ Özellikler

- Spring Boot altyapısı
- Katmanlı mimari (Controller - Service - Repository - Entity - DTO)
- Hibernate / JPA ile ORM
- Lombok ile sadeleştirilmiş model kodları
- ModelMapper ile DTO-Entity dönüşümü
- Global Exception Handling
- Standart JSON Response yapısı

---

## 🏛️ Katman Yapısı
restapi
├── src
│ └── main
│ └── java
│ └── dev.spring.restapi
│ ├── api # Controllers
│ ├── business # Services (Abstracts + Concretes)
│ ├── core # Configs, Exception Handling, Utils
│ ├── dao # Repositories
│ ├── dto # Request / Response DTOs
│ └── entities # JPA Entities
├── pom.xml
└── application.properties

[ CLIENT (Postman veya Browser) ]
│
│ HTTP Request (JSON)
▼
┌──────────────────────────────┐
│ CONTROLLER │
└─────────────┬────────────────┘
│ çağırır
▼
┌──────────────────────────────┐
│ SERVICE │
└─────────────┬────────────────┘
│ çağırır
▼
┌──────────────────────────────┐
│ REPOSITORY │
└─────────────┬────────────────┘
│ çağırır
▼
┌──────────────────────────────┐
│ ENTITY │
└─────────────┬────────────────┘
│
▼
┌──────────────────────────────┐
│ DATABASE │
└──────────────────────────────┘

- **Controller:** REST endpoint’leri tanımlar.
- **Service:** İş mantığı ve DTO dönüşüm işlemleri.
- **Repository:** Veritabanı işlemleri.
- **Entity:** Veritabanı tablo karşılıkları.
- **DTO:** Veri taşıma nesneleri.
- **Core:** Ortak konfigürasyon, Exception Handling, Response Wrapper.

---

## 🛠️ Kullanılan Teknolojiler

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- Lombok
- ModelMapper
- MySQL
- Maven

---
Properties Bölümü
spring.datasource.url=jdbc:mysql://localhost:3306/restapi
spring.datasource.username=admin
spring.datasource.password=**

📬 Örnek API Endpoint’leri
Kategori Kaydet: POST /api/categories/save

Kategori Listele: GET /api/categories

Ürün Kaydet: POST /api/products/save

Tedarikçi Kaydet: POST /api/suppliers/save

Bu endpoint çıktılarının hepsini postman ile yaptım.

Örnek Json
/api/categories/save api ucu 
Post
{
  "name": "SpringBoot"
}

Response
{
  "success": true,
  "message": "Kategori eklendi.",
  "data": {
    "id": 1,
    "name": "SpringBoot"
  }
}



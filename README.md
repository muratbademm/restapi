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
Kategori Kaydet: POST /v1/categories

Kategori Listele: GET /v1/categories

Ürün Kaydet: POST /v1/products

Tedarikçi Kaydet: POST /v1/suppliers


<img width="884" height="551" alt="postman" src="https://github.com/user-attachments/assets/f1bb05d4-8cd5-4891-be9f-5039afa72445" />



<img width="818" height="425" alt="database" src="https://github.com/user-attachments/assets/c5340eb4-6397-417e-aba1-ef084684fcec" />


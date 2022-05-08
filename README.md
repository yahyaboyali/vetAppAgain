# vetApplication
genel isterler doğrultusunda büyük çoğunluğu yapabilen bir uygulama

# Kullanılan Teknolojiler

+ Java
+ Spring boot
+ maven
+ JPA Repository
+ PostgreSQL
+ Bootstrap
+ Thymleaf

# Genel Dosyalama mimarisi görünümü

![genel görünüm](https://i.hizliresim.com/ed1jira.PNG)

#Veritabanı ilişki modeli
2 adet tablo kullandım. Entity'lerim için. Person ve Animal.
![veritabanı görünümü](https://i.hizliresim.com/2yzv7cg.PNG)

Bir kullanıcının birden fazla hayvanı olabilmeli isteği için ilişkisini person Tarafında oneToMany olarak belirledim. 

Aynı veritabanı tasarımını Kodlarken Entitylerimde de kullandım. 
![ilişli görünümü](https://i.hizliresim.com/lj4zbnk.png)

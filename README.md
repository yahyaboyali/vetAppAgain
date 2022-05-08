# vetApplication
genel isterler doğrultusunda büyük çoğunluğu yapabilen bir uygulama
# UYGULAMAYI BAŞLATMA

# Kullanılan Teknolojiler

+ Java
+ Spring boot
+ maven
+ JPA Repository
+ PostgreSQL
+ Bootstrap
+ Thymleaf
+ lombok

# Genel Dosyalama mimarisi görünümü

![genel görünüm](https://i.hizliresim.com/ed1jira.PNG)

#Veritabanı ilişki modeli
2 adet tablo kullandım. Entity'lerim için. Person ve Animal.
![veritabanı görünümü](https://i.hizliresim.com/2yzv7cg.PNG)

Bir kullanıcının birden fazla hayvanı olabilmeli isteği için ilişkisini person Tarafında oneToMany olarak belirledim. 

Aynı veritabanı tasarımını Kodlarken Entitylerimde de kullandım. 
![ilişli görünümü](https://i.hizliresim.com/lj4zbnk.png)

# sayfa görünümleri
## login sayfası
![login](https://i.hizliresim.com/2gswas7.PNG)
## kullanıcı ekleme ekranı
![kullanıcı ekleme](https://i.hizliresim.com/4jq91fx.PNG)
## Giriş yapıldıktan sonraki ekran
![after login](https://i.hizliresim.com/m2ql7ws.PNG)
## hayvan listesi
![after login](https://i.hizliresim.com/nbu6inc.PNG)
## hayvan ekleme
![after login](https://i.hizliresim.com/ijdgv3r.PNG)
## detaylı hayvan ismi üzerine tıklanınca çıkan görünüm
![detay görünüm](https://i.hizliresim.com/8f2fizt.PNG)
## detaylı hayvan ismi üzerine tıklanınca çıkan görünüm
![detay görünüm](https://i.hizliresim.com/ahrqbes.PNG)

# İstenilen özelliklerin Video kayıtları
## aşağıdaki videoda 
+ kullanıcı ekleme
+ hayvanları listeleme
+ güncelleme
+ silme
+ ekleme
+ isme göre arama 
+ kullanıcı adına göre arama
+ başlangıç harflerine göre arama
+ içeriğinde girilen harfi içerenleri arama
+ özellikleri mevcut
[video linki](https://drive.google.com/file/d/1V5EHInSCOgv18aPVxqsHGR0k7jA1PclI/view?usp=sharing)
## diğer bir videoda 
+ hayvan listesinde detaylı görünüm için isminin üzerine tıklandığında açılan detay sayfası
+ kullanıcının ismine tıklandığında sahip olduğu hayvanlara ait detayların sayfası mevcut
+ [video linki](https://drive.google.com/file/d/11uDXZu7Hvx_xggBwcrkdLSThmVbJIySw/view?usp=sharing)
# Kod tanıtımı
Mimarimden de anlaşılacağı üzere:
+ Entity
+ dataAccess
+ bussiness 
+ core
+ api
+
şeklinde kodlarımı parçaladım. entity kısmında tablodaki özelliklere göre verileri eşleştirdim
lombok sayesinde constructor ve getter setter işlemlerimi yazmadan kolayca hallettim. 
# DataAccess kısmı
Dao kısmımı veriye eriştiğim bölümü buraya ekledim. JPA kullanarak çoğu özelliğe sahip olduğumdan ziyade kendime has özellikleri de buraya ekledim. 
![dao görünüm](https://i.hizliresim.com/p7qfw8f.PNG)
örneğin burada person özelliğine göre hayvan arayabilmek adına kendi methodumu yazdım. 
gerek duymadım ama Query kullanarak da farklı methodlar ekleyebilirdim.
# Bussiness kısmı
## Service 
servis kısmının görünümü şu şekilde bir adet interface yazdım. 
![image](https://user-images.githubusercontent.com/56196447/167298884-23bc3b0b-0999-4fbd-af01-b5fec1a74049.png)
burada kullandığım methodların gövdesi olarak gösterimini yaptım. 
## Manager kısmı
service kısmında yazdığım gövdesiz methodları burada implement ederek işlevli hale getirdim
![image](https://user-images.githubusercontent.com/56196447/167298986-d14f45fa-0d1e-4751-a486-f7dbb1d56c69.png)
burada üst kısımda service olduğunu belirttim ve aşağıda görüldüdüğü üzere 
bir bağımlılık oluşturdum. yazmış olduğum dao burada kullanılmak zorunda olduğunu dependency injection yaparak belirttim.
#Controller Api kısmı
bu kısımda durum şöyle normalde api yazıp üzerine farklı bir yapıyla örneğin react kullanarak bu api'me istekte bulunuyordum. mimarimi bozmamak adına aynı yoldan
devam ettim.
![image](https://user-images.githubusercontent.com/56196447/167299116-d34f84b2-fc4b-4179-9c93-e091882c58b6.png)
buraya da service kısmında olduğu gibi dependency injection uyguladım ve yazmış olduğum servise bağımlı hale getirdim. 
![image](https://user-images.githubusercontent.com/56196447/167299194-1cc5cbf3-ae4b-42c2-aa17-dd5f94396522.png)
görüldüğü üzere methodlarımı get ve post olarak ayrı ayrı map işlemine tabi tuttum.Servisimde yazmış olduğum methodlara göre işlemlerimi gerçekleştirdim.

#Result yapısı
core kısmında ayrı bir result yapısı kullandım. Bunu daha önce farklı bir yerden öğrenmiştim ve projelerimi bu iskelete göre yapmaya özen gösteriyordum. bu projede de
bunu eksik etmedim. 
yapım şöyle ana bi Result class'ımdan Success ve Error durumlarına göre ayrılmış extend durumlarını ayırdım. 
Data Durumu da olacağından aynı şekilde SuccessData ve ErrorData durumlarını ekledim. bunların hepsi birbirine bağlantılı extend durumunda kullanılıyor. 
her ihtimali düşünerek ilerledim. 
örneğin successData durumunda Data, mesaj ve success bilgisi yani true bilgisini constructor olarak ekledim. 
##  Ana Result class
![image](https://user-images.githubusercontent.com/56196447/167299386-7265a3f9-0a27-4a7c-bba4-8e8b144489ef.png)

## Eğer Resultta Data olabilirse
![image](https://user-images.githubusercontent.com/56196447/167299429-296004b7-af16-42b2-a25b-033c7a3232e4.png)

## SuccessDataResult görünümü
![image](https://user-images.githubusercontent.com/56196447/167299479-65cd4dde-5072-4de9-880f-cf287c3bb2ad.png)
şeklinde result durumumu ayarladım.

# SON olarak
yapımı kurumsal bir mimariye göre kurgulamak istedim projelerimde kullanıma özen gösteriyorum. Engin Demiroğ hocanın java kamp videolarından öğrendim. 
kod karmaşasını bana göre önleyen bir yapı olduğunu düşünüyorum. yeni özellikler ekleme konusunda çok esnek hiçbir kodu bozmadan yeni eklentileri ekleyebiliyorum.
Gecikme için üzgünüm. 

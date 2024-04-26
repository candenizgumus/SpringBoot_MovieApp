
# Bu Monolitik Spring Boot projesi Katmanlı Mimari ile Geliştirilecek.
## 4 farklı entity olacak.(Movie,User,MovieComment,Genre)

## Database: MovieAppDB
## application.yml dosyasını kendiniz hazırlayacaksınız.
## bir önceki projeden alınabilecekler:
1. Exception Package
2. Utility Package
3. Constant Package > Endpoints içinde gerekli değişiklikleri yapınız.

## Soru 1.
### Entityleri hazırlayın.
### Repositoryler.
### Serviceler. (Repository inject edin.)
### Controller.  (Serviceler inject edin.)

## Soru 2.
### MovieComment içinde yorum yapan USER, yorum yapılan MOVIE bilgileri tutulmalı. İlişkileri ayarlayınız.

### Movie içinde Genre kısmında bir film birden çok genrede olabilir, bir genrede birden çok movie olabilir. Şeklinde bir kabulle ilişkileri ayarlayınız.

### Movie içinde commentlere de erişilmek isteniyor. İlişkisini kurarak Movie'ı güncelleyiniz.

### User içinde favMovies: Bir filmi birden çok kişi favoriye alabilir. Bir kişi birden çok filmi favoriye alabilir kabulünü göre ilişkileri kurunuz.

### User içinde favGenre: favMovies ile aynı mantıkta olabilir.

### User içinde kendi yaptığı yorumlara da erişmek istenebilir.


## Soru 3. https://api.tvmaze.com/shows apisine istek atarak gelen verileri bizde bulunan movie entity'si türüne çevirerek vt'ye kaydetmeliyiz.
Bu apiye istek atarken herhangi bir metod kullanabilirsiniz. HttpUrlConnection
Gson kullanarak dönüşüm yaptırabilirsiniz.
Bu DataImpl sınıfı spring projesi ayağa kalkarken yüklenmeli ve içindeki metodu tetiklemelidir.

## Soru 4. Tüm filmleri listeleyecek endpointi yazınız.

// ----------------------- WIDOK -----------------------------

// miejsce na liste danych
var testAnimalTableData = [];

// tworzenie jquery datatable
function createTestAnimalTable() {
    $(document).ready(function () {
        $('#test-animal-table').DataTable({
            data: convertTestAnimalDataForTable(testAnimalTableData),
            columns: [
                {title: "Id"},
                {title: "Gatunek"},
                {title: "Rasa"},
                {title: "Imię"},
                {title: "Wiek"}
            ]
        });
    });
}

// ustawianie reakcji na klikniecie: pobranie danych dla wskazanego wiersza (po ID) i uzupelnienie formularza pobranymi danymi
function createTestAnimalTableEvents() {
    $('#test-animal-table').on('click', 'tbody tr', function () {
        var table = $('#test-animal-table').dataTable();
        var row = table.fnGetData(this);
        var response = getTestAnimalDataForForm(row[0]); // jezeli wszystko poszlo dobrze, w kolumnie 0 powinien znajdowac sie ID
        testAnimalObjectToForm(response);
    })
}

// odswiezenie tabeli
function reinitializeTestAnimalTable() {
    $('#test-animal-table').DataTable().destroy();
    createTestAnimalTable();
}

// czyszczenie formularza
function clearTestAnimalForm() {
    document.getElementById('test-animal-id').value = null;
    document.getElementById('test-animal-species').value = null;
    document.getElementById('test-animal-race').value = null;
    document.getElementById('test-animal-name').value = null;
    document.getElementById('test-animal-age').value = null;
    document.getElementById('test-animal-color').value = null;
    document.getElementById('test-animal-notes').value = null;
}

// przepisanie formularza do obiektu
function testAnimalFormToObject() {
    return {
        id: document.getElementById('test-animal-id').value,
        gatunek: document.getElementById('test-animal-species').value,
        rasa: document.getElementById('test-animal-race').value,
        imie: document.getElementById('test-animal-name').value,
        wiek: document.getElementById('test-animal-age').value,
        kolor: document.getElementById('test-animal-color').value,
        uwagi: document.getElementById('test-animal-notes').value
    }
}

// przepisanie obiektu do formularza
function testAnimalObjectToForm(animal) {
    document.getElementById('test-animal-id').value = animal.id;
    document.getElementById('test-animal-species').value = animal.gatunek;
    document.getElementById('test-animal-race').value = animal.rasa;
    document.getElementById('test-animal-name').value = animal.imie;
    document.getElementById('test-animal-age').value = animal.wiek;
    document.getElementById('test-animal-color').value = animal.kolor;
    document.getElementById('test-animal-notes').value = animal.uwagi;
}

// konwersja listy obiektow do listy tablic (wymagane przez datatables)
function convertTestAnimalDataForTable(objectList) {
    var arrayList = [];
    for (var i = 0; i < objectList.length; i++) {
        var record = [objectList[i].id, objectList[i].gatunek, objectList[i].rasa, objectList[i].imie, objectList[i].wiek, objectList[i].kolor, objectList[i].uwagi];
        arrayList[i] = record;
    }
    return arrayList;
}

// ----------------------- KOMUNIKACJA -----------------------------

// pobranie pojedynczego rekordu po id z serwera
function getTestAnimalDataForForm(id) {
    var url = HOST + '/api/animals/findOne';
    var params = '?id=' + id;
    var response = httpGet(url + params);
    return JSON.parse(response);
}

// pobranie wszystkich rekordow z serwera i odswiezenie tabeli
function getTestAnimalDataForTable() {
    var url = HOST + '/api/animals/findAll';
    var response = httpGet(url);
    testAnimalTableData = JSON.parse(response);
    reinitializeTestAnimalTable();
}

// zapis danych z formularza na serwerze, operacja zapisu na serwerze zwraca swiezo zapisany obiekt,
// z ktorego ID jest przepisywane do formularza, nastepuje tez odswiezenie tabeli
function saveTestAnimalForm() {
    var formData = testAnimalFormToObject();
    var url = HOST + '/api/animals/save';
    var response = httpPost(url, formData);
    var responseObject = JSON.parse(response);
    document.getElementById('test-animal-id').value = responseObject.id;
    //TODO// var response = httpPost(url, testAnimalFormToObject()); // nie da sie odrazu funkcja, zamiast formData?
    getTestAnimalDataForTable();
}

// usuniecie z serwera rekordu obecnie wybranego w formularzu (po ID) i odswiezenie tabeli
function deleteSelectedTestAnimal() {
    var id = document.getElementById('test-animal-id').value;
    var url = HOST + '/api/animals/deleteOne';
    var params = '?id=' + id;
    httpGet(url + params);
    clearTestAnimalForm();
    getTestAnimalDataForTable();
}
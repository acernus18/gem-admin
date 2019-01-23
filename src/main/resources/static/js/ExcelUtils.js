/**
 * Load data from file;
 *
 * @param file excel file;
 * @return data Like {"Sheet1": [{...}, {...}]}
 */
function parseExcelToObject(file) {
    let fileReader = new FileReader();

    let result = {};

    fileReader.onload = function () {
        let data = fileReader.result;
        let workbook = XLSX.read(data, {type: 'binary'});

        for (let sheet in workbook.Sheets) {
            if (workbook.Sheets.hasOwnProperty(sheet)) {
                result[sheet] = XLSX.utils.sheet_to_json(workbook.Sheets[sheet]);
            }
        }
    };

    fileReader.readAsBinaryString(file);
    return result;
}


/**
 * Dump to excel file;
 *
 * @param data Like {"Sheet1": [{...}, {...}]}
 * @param filename String
 */
function dumpObjectToExcel(data, filename) {
    let workbook = XLSX.utils.book_new();

    for (let sheet in data) {
        if (data.hasOwnProperty(sheet)) {
            XLSX.utils.book_append_sheet(workbook, XLSX.utils.json_to_sheet(data[sheet]), sheet);
        }
    }

    let workbookOut = XLSX.write(workbook, {bookType: 'xlsx', type: 'array'});
    let blob = new Blob([workbookOut], {type: 'application/octet-stream'});

    let link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = filename;
    link.click();
    setTimeout(function () {
        URL.revokeObjectURL(link.href);
        link.remove();
    }, 500);
}

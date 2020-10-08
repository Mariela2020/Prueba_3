const report = require('multiple-cucumber-html-reporter');

report.generate({
    jsonDir: './test/report/',
    reportPath: './test/report/',
    openReportInBrowser: false,
    metadata:{
        browser: {
            name: 'chrome',
            version: '60'
        },
        device: 'Local test machine',
        platform: {
            name: 'Windows',
            version: '10'
        }
    },
    customData: {
        title: 'Run info',
        data: [
            {label: 'Project', value: 'TOCTOC Gestión Corredora'},
            {label: 'Release', value: '1.2.3'},
            {label: 'Cycle', value: 'B11221.34321'},
            {label: 'Execution Start Time', value: 'Ago 11th 2020, 19:28 PM'},
            {label: 'Execution End Time', value: 'Ago 11th 2020, 19:28 PM'}
        ]
    }
});
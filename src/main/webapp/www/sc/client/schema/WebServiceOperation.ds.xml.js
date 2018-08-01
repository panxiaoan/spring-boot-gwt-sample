isc.DataSource.create({
    allowAdvancedCriteria:true,
    addGlobalId:false,
    ID:"WebServiceOperation",
    fields:[
        {
            name:"name",
            title:"Operation Name",
            required:true,
            validators:[
            ]
        },
        {
            name:"soapAction",
            title:"SOAPAction Header",
            validators:[
            ]
        },
        {
            name:"inputMessage",
            title:"Input Message",
            validators:[
            ]
        },
        {
            name:"outputMessage",
            title:"Output Message",
            validators:[
            ]
        },
        {
            multiple:true,
            name:"inputHeaders",
            type:"WSOperationHeader",
            validators:[
            ]
        },
        {
            multiple:true,
            name:"outputHeaders",
            type:"WSOperationHeader",
            validators:[
            ]
        }
    ]
})

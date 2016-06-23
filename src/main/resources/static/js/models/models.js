window.Question = Backbone.Model.extend({
    urlRoot: '/questions',
    defaults:{
    	id:null,
    	question:''
    }
});

window.QuestionCollection = Backbone.Collection.extend({
    model: Question,
    url: '/questions'

});
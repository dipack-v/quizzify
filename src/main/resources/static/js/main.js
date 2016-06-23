var AppRouter = Backbone.Router.extend({
    routes: {
        ""                  : "list",
        "questions/:id"     : "showQuestion"
    },

    initialize: function () {},

    list: function(page) {
        var questionList = new QuestionCollection();
        questionList.fetch({success: function(){
            $("#question-panel").html(new QuestionView({model: questionList.at(0)}).el);
        }});
    },

    showQuestion: function (id) {
        var wine = new Wine({id: id});
        wine.fetch({success: function(){
            $("#content").html(new WineView({model: wine}).el);
        }});
    }

});

utils.loadTemplate(['QuestionView'], function() {
    app = new AppRouter();
    Backbone.history.start();
});
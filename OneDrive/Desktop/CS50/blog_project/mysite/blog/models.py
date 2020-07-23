from django.db import models
from django.utils import timezone
from django.core.urlresolvers import reverse

# create model
class Post(models.Model):
    author = models.ForeignKey('auth.User', on_delete=models.DO_NOTHING)
    title = models.CharField(max_length=200)
    text = models.TextField()
    create_date = models.DateTimeField(default=timezone.now())
    published_data = models.DateTimeField(blank=True,null=True)

    def publish(self):
        self.published_data = timezone.now()
        self.save()

    #show approved comment
    def approve_comments(self):
        return self.comments(approved_comment=True)

    def get_absolute_url(self):
        return reverse("post_detail",kwargs={'pk':self.pk})

    def __str__(self):
        return self.title


class Comment(model.Model):
    post = models.ForeignKey("blog.Post",related_name="comments",on_delete=models.DO_NOTHING)
    author = models.CharField(max_length=200)
    text = models.TextField()
    create_data = models.DateTimeField(default=timezone.now())
    approved_comment = models.BooleanField(default=False)

    def approve_comments(self):
        self.approved_comment=True
        self.save()

    def get_absolute_url(self):
        return reverse("post_list")

    def __str__(self):
        return self.text

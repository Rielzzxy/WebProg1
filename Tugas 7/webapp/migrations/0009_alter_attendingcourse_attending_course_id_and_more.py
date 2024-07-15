# Generated by Django 5.0.4 on 2024-07-07 07:57

import uuid
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('webapp', '0008_alter_attendingcourse_attending_course_id_and_more'),
    ]

    operations = [
        migrations.AlterField(
            model_name='attendingcourse',
            name='attending_course_id',
            field=models.UUIDField(default=uuid.UUID('c4555a2e-765b-4721-b74d-14ebb72079e7'), editable=False, primary_key=True, serialize=False, unique=True),
        ),
        migrations.AlterField(
            model_name='course',
            name='course_id',
            field=models.UUIDField(default=uuid.UUID('8e2e01e7-014f-43ff-94dc-c41447578031'), editable=False, primary_key=True, serialize=False, unique=True),
        ),
    ]
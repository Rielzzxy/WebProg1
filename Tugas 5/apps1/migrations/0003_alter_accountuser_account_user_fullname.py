# Generated by Django 5.0.6 on 2024-06-25 09:17

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('apps1', '0002_rename_apps1_accou_account_d092da_idx_apps1_accou_account_e66dc4_idx_and_more'),
    ]

    operations = [
        migrations.AlterField(
            model_name='accountuser',
            name='account_user_fullname',
            field=models.CharField(max_length=255),
        ),
    ]
